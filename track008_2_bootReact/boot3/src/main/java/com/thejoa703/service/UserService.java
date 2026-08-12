package com.thejoa703.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //### spring
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.exception.ResourceNotFoundException;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true) // 데이터 저장(insert)시 실패할 경우 roll back  / readOnly=true 읽기전용(더티체킹방지) - 메모리 낭비하지 않기위함
public class UserService {
	
	private final AppUserRepository appUserRepository; //## @Autowired 대신 @RequiredArgsConstructor + private final 권장!
	private final FileStorageService fileStorageService; // 파일 올리기
	// 보안 : 비밀번호 암호화 
	private final PasswordEncoder passwordEncoder; // 보안 : 비밀번호 암호화 ##	
	// create : 회원가입 (사용자등록)
	@Transactional
	public UserResponseDto createUser(UserRequestDto request, MultipartFile profileImage) {
		String provider = request.getProvider() != null? request.getProvider() : "local";
		
		if(appUserRepository.findByEmailAndProvider(request.getEmail(), provider).isPresent()) { 
			throw new IllegalArgumentException("이미 존재하는 사용자입니다."); 
			}
		
		if(appUserRepository.existsByNickname(request.getNickname())) { // react에서 한번 거르지만 한번더 체크
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다."); 
			}
		//※ 이메일 중복검사 / 닉네임 중복검사  (도전!) ( existsBy필드명 )
		//if(appUserRepository.findByEmail(requestDto.getEmail())) {  }
		AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); //## 암호화
        user.setNickname(request.getNickname());
        user.setProvider(provider);
        user.setRole("ROLE_USER");
        user.setUfile(profileImage != null && !profileImage.isEmpty()
        		      ?  fileStorageService.upload(profileImage) 
        		      :  "uploads/thejoa703.png");
						
		return UserResponseDto.fromEntity(appUserRepository.save(user)); // 유저 생성
	}
	
	// read : 이메일 중복검사
	public boolean existsByEmail(String email) { return appUserRepository.existsByEmail(email); }
	
	// read : 닉네임 중복검사
	public boolean existsByNickname(String nickname) { return appUserRepository.existsByNickname(nickname); }
	
	// read : 로그인
	public UserResponseDto login(LoginRequest request) {
		AppUser user = appUserRepository
					   .findByEmailAndProvider(request.getEmail(), request.getProvider() != null? request.getProvider() : "local")
					   .orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));
		//                           사용자가 입력한 값       ,  DB의 비밀번호
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("비밀번호 불일치");
		}
		
		return UserResponseDto.fromEntity(user);
	}
	//userService.findByEmailAndProvider(userInfo.getEmail(), userInfo.getProvider())
    // .orElseGet(() -> userService.saveSocialUser(
	
	// #### 사용자 조회
	public Optional<AppUser> findByEmailAndProvider(String email, String provider){
		return appUserRepository.findByEmailAndProvider(email, provider);
	}
	
	// #### saveSocialUser
	@Transactional // ###### social - insert
	public AppUser saveSocialUser( String email, String provider, String providerId, String nickname, String image) {
	      AppUser user  = AppUser.builder()
	                        .email(email)
	                        .provider(provider)
	                        .providerId(providerId)
	                        .nickname(nickname)
	                        .ufile(image)
	                        .password(passwordEncoder.encode("thejoa703")) // ## social - security (UUID 사용하는게 좋음)
	                        .role("ROLE_USER")
	                        .build();
	      return appUserRepository.save(user);  
	   }
	
	// ##### 권한 조회
	public String findRoleByUserId(Long userId) {
		   return   appUserRepository.findById(userId)       
		                       .map(AppUser::getRole)   
		                       .orElse("ROLE_USER");    
		}
	
	// read : 사용자 단건 조회(마이페이지)
	public UserResponseDto getUser(Long userId) { // Optional - 값 1개 or null
		AppUser user = appUserRepository.findById(userId)
				          .orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 사용자입니다. id" + userId) );
		return UserResponseDto.fromEntity(user);
	}
	// read : 전체 사용자 수, 정보
	public long countUsers() { return appUserRepository.count(); }
	
	// update : 닉네임 변경 
	@Transactional
	public UserResponseDto updateNickname(Long userId, String newNickname) {
		if(appUserRepository.existsByNickname(newNickname)) { 
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다."); 
			}
		
		AppUser user = appUserRepository.findById(userId)
						.orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다. ID: " + userId));
		
		user.setNickname(newNickname); // 값변경 → 트랜잭션 종료시 자동 update (save한 효과)
		return UserResponseDto.fromEntity(user);
	}
	// update : 프로필 이미지 변경
	@Transactional
	public UserResponseDto updateProfileImage(Long userId,  MultipartFile profileImage) {
		// 해당 유저 번호 받아서 유저찾기
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다. ID: " + userId));
		// 수정
		user.setUfile(profileImage != null && !profileImage.isEmpty()
  		      ?  fileStorageService.upload(profileImage) 
  		      :  "uploads/thejoa703.png");
		return UserResponseDto.fromEntity(user);
	}
	
	// delete : 회원 탈퇴
	@Transactional
	public void deleteById(Long userId) {
		// 선택1) 소프트 딜리트 - 프로필 이미지변경 예시처럼 수정
		if(!appUserRepository.existsById(userId)) {
			throw new IllegalArgumentException("삭제할 사용자가 존재하지 않습니다. ID: " + userId);
		}
		
		appUserRepository.deleteById(userId); // 선택2) 실제 DB에서 삭제(하드 딜리트)
	}
}
/*
회원가입 (이메일 중복검사, 닉네임 중복검사) 
↓
로그인 
↓
마이페이지 (닉네입변경, 프로필 이미지변경, 회원탈퇴, 로그아웃)
*/
