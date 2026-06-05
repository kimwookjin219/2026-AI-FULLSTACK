package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class) //1. spring 구동테스트
@ContextConfiguration(locations="classpath:config/root-context.xml") //2. 설정
public class ModelTest { 
	
	@Autowired ApplicationContext context; //3. Bean ( 스프링이 관리하는 객체 ) 생성~소멸
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper test;
	@Autowired BoardMapper board;
	@Autowired BoardService service;
	
	@Test
	public void test6() {
		// 삭제
//		BoardDto dto = new BoardDto(); dto.setBno(3);
//		System.out.println(service.delete(dto));
		// 수정
//		BoardDto dto = new BoardDto(); 
//		dto.setBname("first"); dto.setBtitle("NEW-serivice 첫글"); 
//		dto.setBcontent("NEW-serivice 안녕2"); dto.setBno(3);
//		System.out.println(service.edit(dto));
		// 한명 검색
		//System.out.println(service.detail(3));
		//삽입 bno=3
//		BoardDto dto = new BoardDto();
//		dto.setBname("first"); dto.setBpass("1234"); 
//		dto.setBtitle("service-첫글"); dto.setBcontent("service-안녕");
//		System.out.println(service.insert(dto));
		//전체 리스트
		System.out.println(service.selectAll());
	}
	
	@Ignore @Test 
	public void test5() throws UnknownHostException { 
		//1. 전체검색
		//System.out.println(board.selectAll()); 
		//2. 삽입
		//bname,bpass,btitle,bcontent,bip
//		BoardDto dto = new BoardDto(); dto.setBname("first"); dto.setBpass("1234"); dto.setBtitle("첫글"); dto.setBcontent("안녕");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress()); #1
//		System.out.println(board.insert(dto)); 실행한 줄 수 1
//		//3. 한명검색
//		System.out.println(board.select(1));
		//4. 수정
//		BoardDto dto = new BoardDto(); dto.setBname("first"); dto.setBtitle("수정 첫글"); dto.setBcontent("안녕2"); dto.setBno(2);
//		System.out.println(board.update(dto));
		//5. 삭제
		//System.out.println(board.delete(2));
		}
	
	@Ignore @Test public void test1() { System.out.println(context); }
	@Ignore @Test public void test2() { System.out.println(sqlSession); }
	@Ignore @Test public void test3() { System.out.println(dataSource); }
	@Ignore @Test public void test4() { System.out.println(test.now()); }
	
	
}
