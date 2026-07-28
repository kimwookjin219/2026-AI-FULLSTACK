package com.thejoa703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //### spring

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true) // 데이터 저장(insert)시 실패할 경우 roll back  / readOnly=true 읽기전용(더티체킹방지) - 메모리 낭비하지 않기위함
public class UserService {
	
	private final AppUserRepository appUserRepository; //## @Autowired 대신 @RequiredArgsConstructor + private final 권장!
	
	//1. 회원가입 (사용자등록)
	@Transactional
	public UserResponseDto createUser(UserRequestDto requestDto) {
		//※ 이메일 중복검사 / 닉네임 중복검사  (도전!) ( existsBy필드명 )
		//if(appUserRepository.findByEmail(requestDto.getEmail())) {  }
		
		AppUser appUser = AppUser.builder()
		       .email(requestDto.getEmail())
		       .password(requestDto.getPassword())
		       .nickname(requestDto.getNickname())
		       .mobile(requestDto.getMobile())
		       .provider("local")
		       .providerId("local")
		       .role("ROLE_USER")
		       .deleted(false)
		       .build();
		
		AppUser savedUser = appUserRepository.save(appUser);
		return new UserResponseDto(savedUser);
	}
	
	//2. 사용자 단건 조회
	public UserResponseDto getUser(Long id) { // Optional - 값 1개 or null
		AppUser appUser = appUserRepository.findById(id)
				          .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 사용자입니다. id" + id) );
		return new UserResponseDto(appUser);
	}
}
