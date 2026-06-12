package com.the703.service;

import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {
	
	public int insert(UserDto dto); //회원가입
	public String findByEmail(String email); //중복검사
	public String findByNickname(String nickname); //중복검사
	public int findLogin(UserDto dto); // 로그인	
	public UserDto findByUno(int uno); // 마이페이지	

	public     AuthUserDto    readAuth( String email );
	public UserDto findByEmailUserInfo(String email);
}

