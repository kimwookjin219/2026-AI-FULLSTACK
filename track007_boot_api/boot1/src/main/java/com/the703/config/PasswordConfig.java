package com.the703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
	@Bean // 스프링이 관리하는 객체
	public PasswordEncoder passwordEncoder() { // 암호화
		return new BCryptPasswordEncoder();
	}
}
