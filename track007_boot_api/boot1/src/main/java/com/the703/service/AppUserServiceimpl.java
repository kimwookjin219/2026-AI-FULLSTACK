package com.the703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.util.UtilUpload;

@Service
public class AppUserServiceimpl implements AppUserService{
	
	@Autowired private AppUserDao dao;
	@Autowired private UtilUpload upload;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Transactional @Override //@Transactional 실패시 다음으로 넘어가지 않음 (sql 구문 2개 이상 사용시 사용하면 좋음)
	public int insert(MultipartFile file, AppUserDto dto) {
		//이미지 업로드
		dto.setUfile("the703.png");
		if(!file.isEmpty()) {
			try { dto.setUfile( upload.fileUpload(file) ); }
			catch (IOException e) { e.printStackTrace(); }
		}
		//비밀번호 암호화
		dto.setProvider("the703");
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		int result = dao.insertAppUser(dto); //#sql 1
		
		//권한
		AuthDto udto = new AuthDto();
		udto.setEmail(dto.getEmail()); udto.setAuth("ROLE_MEMBER");
		if(result>0) { dao.insertAuth(udto); } //#sql 2
		
		return result;
	}
	
	@Override public AppUserAuthDto readAuthByEmail(String email, String provider) { // 로그인
		AppUserDto dto = new AppUserDto(); dto.setEmail(email);
		return dao.readAuthByEmail(dto); 
	}
	
	@Override public AppUserDto selectEmail(String email, String provider) { //마이페이지
		AppUserDto dto = new AppUserDto(); dto.setEmail(email);
		return dao.findByEmail(dto); 
	}
	
	@Override public int iddouble(String email, String provider) { //이메일 중복
		AppUserDto dto = new AppUserDto(); dto.setEmail(email);
		return dao.iddoubleByEmail(dto); 
	}
	
	//로그인 한 유저 맞는지 확인 - 비번 맞는지 확인
	@Override public boolean matchesPassword(String email, String provider, String rawPassword) {
		//1. dbUser 찾기
		AppUserDto dbUser = new AppUserDto(); dbUser.setEmail(email);
		AppUserDto result = dao.findByEmail(dbUser);
		//2. 비번 맞는지 확인		
		return result != null && result.getPassword() != null && 
				passwordEncoder.matches(rawPassword, result.getPassword()); //사용자가 입력한 비번과 DB비번이 일치하는지 확인
	}
	
	@Transactional @Override public int delete(AppUserDto dto, boolean local) {
		// 비밀번호가 틀리면 리턴값 0
		if(!matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword())) { return 0; } 
		
		// 비밀번호가 맞으면 삭제		
		AuthDto adto = new AuthDto(); adto.setEmail(dto.getEmail()); adto.setAuth("ROLE_MEMBER");
		dao.deleteAuth(adto); //권한 삭제		
		return dao.deleteAppUser(dto); //유저 삭제
	}
	
	@Transactional @Override public int update(MultipartFile file, AppUserDto dto) { 
		// 비밀번호가 틀리면 리턴값 0
		if(!matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword())) { return 0; }
		
		// 이미지 업로드 기능
		//dto.setUfile(dto.getUfile()); // 기존 이미지 (생략가능한 코드)
		if(!file.isEmpty()) {
			try { dto.setUfile( upload.fileUpload(file) ); }
			catch (IOException e) { e.printStackTrace(); }
		}
		
		// 비밀번호 바꾸기(도전해보기)
		
		return dao.updateAppUser(dto);
	}
	
	
}
