package com.the703.service;


import com.the703.dto.UserDto;

public interface UserService {
	//■1. 회원가입
	public int insert(UserDto dto);
	//■2. 아이디 중복검사
	public String findByEmail(String email);
	//■3. 로그인
	public int findLogin(UserDto dto);
	//■4. 마이페이지
	public UserDto findByUno(int uno);
}
