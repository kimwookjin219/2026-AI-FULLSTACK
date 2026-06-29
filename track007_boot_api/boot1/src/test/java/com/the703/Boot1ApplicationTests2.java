package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.service.AppUserService;


@SpringBootTest
class Boot1ApplicationTests2 {
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	//삭제
	@Disabled @Test public void delete_service_User() {
		AppUserDto user = new AppUserDto();	
		user.setEmail("2@2"); user.setPassword("2"); user.setAppUserId(41);
		// 비밀번호 다르면 삭제 X
		
		assertEquals(1, service.delete(user,true));		
	}
	
	
	//수정
	@Disabled @Test public void update_service_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("2@2"); user.setPassword("2"); user.setMbtiTypeId(2); 
		user.setNickname("22"); user.setUfile("222.png"); user.setMobile("01011111112"); 
		user.setProvider("local"); user.setProviderId("local_001"); user.setAppUserId(41);
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text" , "text/plain","data".getBytes());
				
		int result = service.update(file, user);	
		
		assertEquals(1, result);
	}
	
	//아이디 중복
	@Disabled @Test public void iddouble_service_User() {
		int iddouble = service.iddouble("2@2", "local");	
		
		assertEquals(1, iddouble);
	}

	//마이페이지
	@Disabled @Test public void mypage_service_User(){
		AppUserDto mypage = service.selectEmail("2@2", "local");	
		
		assertNotNull(mypage); // null인지 아닌지 판별
		assertEquals("2@2", mypage.getEmail());
	}
	
	//로그인
	@Disabled @Test public void login_service_User() {
		AppUserAuthDto login = service.readAuthByEmail("2@2", "local");
		
		assertNotNull(login); // null인지 아닌지 판별
		assertEquals("2@2", login.getEmail());
		assertTrue( login.getAuthList().stream().anyMatch(a -> "ROLE_MEMBER".equals(a.getAuth())) );
	}
	
	//회원가입
	@Disabled @Test public void insert_service_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("2@2"); user.setPassword("2"); user.setMbtiTypeId(2); 
		user.setNickname("2"); user.setUfile("2.png"); user.setMobile("01011111111"); 
		user.setProvider("local"); user.setProviderId("local_001");
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text" , "text/plain","data".getBytes());
		
		int result = service.insert(file,user);
		assertEquals(1, result);    // 예상되는 결과  , 코드
	}
	
	//////////////////////////////////////////////////////////
	@Disabled @Test public void update_User(){//6. 수정 ( 동적sql )
		AppUserDto user = new AppUserDto();
		user.setPassword("2"); user.setMbtiTypeId(1); 
		user.setNickname("1"); user.setUfile("2.png"); user.setMobile("01011111111"); 
		user.setProvider("local"); user.setProviderId("local_001"); user.setAppUserId(22);
		
		assertEquals(1, dao.updateAppUser(user));
	}	
		
	@Disabled @Test public void delete_User(){//5. 사용자 삭제 + 권한 삭제
		AuthDto auth = new AuthDto();	
		auth.setEmail("1@1");
		
		assertEquals(1, dao.deleteAuth(auth));
		
		AppUserDto user = new AppUserDto();
		user.setAppUserId(21);
		assertEquals(1, dao.deleteAppUser(user));
	}
	
	@Disabled @Test public void mypage_User(){//4. 마이페이지
		AppUserDto user = new AppUserDto();	
		user.setEmail("1@1");
		assertEquals("1@1",dao.findByEmail(user).getEmail());
	}
	
	@Disabled @Test public void iddouble_User(){//3. 아이디 중복검사
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		assertEquals(1,dao.iddoubleByEmail(user));
	}
	
	
	@Disabled @Test public void login_User() { //2. 로그인
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		
		assertNotNull(dao.readAuthByEmail(user)); // null인지 아닌지 판별
	}
	
	@Disabled @Test public void insert_User() { //1. 회원가입 - 유저등록 + 권한등록
		AppUserDto user = new AppUserDto();
		
		user.setEmail("1@1"); user.setPassword("1"); user.setMbtiTypeId(1); 
		user.setNickname("1"); user.setUfile("1.png"); user.setMobile("01011111111"); 
		user.setProvider("local"); user.setProviderId("local_001");
		
		int result = dao.insertAppUser(user);
		assertEquals(1, result);    // 예상되는 결과  , 코드
		//org.junit.jupiter.api.Assertions.assertEquals
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1"); auth.setAuth("ROLE_USER");
		int result_auth = dao.insertAuth(auth);
		assertEquals(1, result_auth);    // 예상되는 결과  , 코드
	}
	
	
}
