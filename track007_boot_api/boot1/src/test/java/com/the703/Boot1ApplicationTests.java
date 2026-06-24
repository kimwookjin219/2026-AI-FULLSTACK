package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
	
	@Autowired TestDao dao;
	@Autowired Sboard2Dao sboard2Dao;
	@Autowired Sboard2Service sboard2Service;
	
	@Disabled @Test public void test06_service_delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(3);
		
		assertEquals(1, sboard2Service.delete(dto));
	} // 삭제
	
	@Disabled @Test public void test06_service_update() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);  dto.setBtitle("new"); dto.setBcontent("new");
		dto.setBpass("1111"); dto.setId(3);
		
		MockMultipartFile file = new MockMultipartFile("file","test.txt","text/plain","data".getBytes());
		int result = sboard2Service.update(file, dto);
		assertEquals(1, result);
	}
	
	@Disabled @Test public void test06_service_detail() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(3);
		
		assertEquals(3, sboard2Service.detail(dto).getId());
	}
	
	@Disabled @Test public void test06_service_list10() {
		assertEquals(4, sboard2Service.list10(1).size()); 
		
		assertEquals(4, sboard2Service.selectCnt());
	}
	
	@Disabled @Test public void test06_service_insert() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);  dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBpass("1111");
		
		MockMultipartFile file = new MockMultipartFile("file","test.txt","text/plain","data".getBytes());
		// org.springframework.mock.web.MockMultipartFile;
		int result = sboard2Service.insert(file, dto);
		assertEquals(1,result);
	}
	
	
	/*              */
	/*              */
	/*              */
	@Disabled @Test public void test05_delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(2);
		int result = sboard2Dao.delete(dto);
		assertEquals(1, result);
	} // 삭제
	
	@Disabled @Test public void test04_update() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setBtitle("new"); dto.setBcontent("new"); dto.setBfile("2.png");
		dto.setId(3);
		int result = sboard2Dao.update(dto);
		assertEquals(1, result);
	} // 수정
	
	@Disabled @Test public void test03_byId() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(3);
		Sboard2Dto result = sboard2Dao.selectById(dto);
		assertEquals(3, result.getId());		
	} // id, 조회수 올리기
	
	@Disabled @Test public void test02_paging() {
		HashMap<String,Object> para = new HashMap<>();
		para.put("start", 0);
		para.put("end", 10);
		List<Sboard2Dto> list10 = sboard2Dao.selectPaging(para);
		assertEquals(2, list10.size()); // 가지고 있는 list의 개수 (예상되는 결과 , 해당 코드)
		assertNotNull(list10);
		assertEquals(2, sboard2Dao.selectCnt()); // 전체개수
		
	} // 페이징 , 갯수
	
	@Disabled //@Test 
	public void test01_Insert() throws UnknownHostException { // insert
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);   dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBpass("1111");  dto.setBfile("1.png");  dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		int result = sboard2Dao.insert(dto);
		System.out.println(".........1 > " + result); // 기존방식 - 수동으로 값 확인: 콘손에 1 확인
		assertEquals(1,result);                       // 자동확인 : 결과물이 1인지 Junit이 체크
	}
	
	//@Ignore - Junit4 버전용
	@Disabled //@Test
	void contextLoads() {
		System.out.println("....................");
		System.out.println(dao.readTime());
		System.out.println("....................");
	}
	
}
