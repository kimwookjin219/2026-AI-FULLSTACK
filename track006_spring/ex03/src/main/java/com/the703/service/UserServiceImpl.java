package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserMapper dao;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Override 
	public int insert(UserDto dto) {
		// 회원가입
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		//dto.setBpass(pwencoder.encode(dto.getBpass()));
		
		return dao.insert(dto);
	}

	@Override
	public String findByEmail(String email) {
		//중복검사
		return dao.findByEmail(email);
	}

	@Override
	public int findLogin(UserDto dto) {
		//로그인
		return dao.findLogin(dto);
	}

	@Override
	public UserDto findByUno(int uno) {
		//마이페이지
		return dao.findByUno(uno);
	}

}
