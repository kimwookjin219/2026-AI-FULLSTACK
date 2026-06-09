package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:config/*-context.xml")
@ContextConfiguration(locations = {"classpath:config/root-context.xml","classpath:config/security-context.xml"})
public class ModelTest2 {
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	//import org.springframework.security.crypto.password.PasswordEncoder;
	
	/* security */
	@Test public void test3() {
		
		/* 로그인시 인가 */
		AuthDto dto2 = new AuthDto(); dto2.setEmail("a@a");
		System.out.println(user.readAuth(dto2));
		
		/* 권한2개 줬으면 주석달고 위에 해당유저정보 가져오기 */
		/* 권한 2개 - 회원, ADMIN */
		//AuthDto dto1 = new AuthDto(); dto1.setEmail("a@a"); dto1.setAuth("ROLE_MEMBER");
//		AuthDto dto1 = new AuthDto(); dto1.setEmail("a@a"); dto1.setAuth("ROLE_ADMIN");
//		System.out.println(user.insertAuth(dto1)); // ROLE_ADMIN,ROLE_MEMBER
		/* 회원가입시 암호화 성공했으면 주석달고 권한 */
		
		/* 회원가입 + 권한등록 */
		/* 회원가입 (암호화) pwencoder.encode("a") */
//		UserDto dto =new UserDto();
//		dto.setNickname("a"); dto.setMobile("010-1234-1234"); 
//		dto.setEmail("a@a"); dto.setBpass(pwencoder.encode("a")); 
//		System.out.println(service.insert(dto));
	}
	
	@Ignore @Test public void test2() throws UnknownHostException {
		//■1. 회원가입
		UserDto dto =new UserDto();
		dto.setNickname("first1"); dto.setMobile("010-1234-1234"); 
		dto.setEmail("first1@gmail.com"); dto.setBpass("1234"); 
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(service.insert(dto));
		//■2. 아이디 중복검사
		System.out.println(service.findByEmail("first1@gmail.com"));
		//■3. 로그인
		UserDto dto1 = new UserDto();
		dto1.setEmail("first1@gmail.com"); dto1.setBpass("1234");
		System.out.println(service.findLogin(dto1));
		//■4. 마이페이지
		System.out.println(service.findByUno(10));
	}
	
	@Ignore @Test public void test1() throws UnknownHostException {
		 //이메일 중복 : findByEmail
		System.out.println(user.findByEmail("first@gmail.com"));
		 //마이페이지 : findByUno
		System.out.println(user.findByUno(9));
		// 로그인 : findLogin
		UserDto dto = new UserDto();
		dto.setEmail("first@gmail.com"); dto.setBpass("1234");
		System.out.println(user.findLogin(dto));
		 //회원가입 : insert	
		UserDto dto1 = new UserDto();
		dto1.setNickname("first"); dto1.setMobile("010-1234-1234"); 
		dto1.setEmail("first@gmail.com"); dto1.setBpass("1234"); 
		dto1.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(user.insert(dto1));
	}
}
