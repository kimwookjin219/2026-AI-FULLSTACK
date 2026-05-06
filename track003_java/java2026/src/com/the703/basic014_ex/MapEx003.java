package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx003 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		Map<String, BookDTO> smap = new HashMap<>();
		Map<String, BookDTO> bmap = new HashMap<>();
		Map<String, Map<String, BookDTO>> library = new HashMap<>();
		
		smap.put( "978-11111" , new BookDTO( "자바의 정석" ,"남궁성" ) );
		smap.put( "978-22222" , new BookDTO( "파이썬 기초" ,"홍길동" ) );
		
		bmap.put( "978-33333" , new BookDTO( "자료구조와 알고리즘" ,"이순신" ) );
		bmap.put( "978-44444" , new BookDTO( "파이썬 심화" ,"홍길동" ) );
		
		library.put("서울점", smap );
		library.put("부산점", bmap );
		
		
		System.out.println("=== 도서관 전체 목록 ===");
		System.out.println("📚 서울점"  ); 
		for( Entry<String, BookDTO> l : smap.entrySet() ) { 
			 String key = l.getKey();
			 BookDTO value = l.getValue();
			 
			if(library.containsKey("서울점")) { 
				System.out.println( key + " | " + value.getTitle() + " | " + value.getAuthor());
				}
		}
		System.out.println("📚 부산점"  );
		for( Entry<String, BookDTO> l : bmap.entrySet() ) { 
			 String key = l.getKey();
			 BookDTO value = l.getValue();
			 
			if(library.containsKey("부산점")) { 
				System.out.println( key + " | " + value.getTitle() + " | " + value.getAuthor());
				}
		}
		
		System.out.print("지점 이름 입력> "); String name = sc.next();
		System.out.print("ISBN 입력> "); String num = sc.next();
		

		if      (library.equals(name))  { System.out.println("📖 선택한 도서 정보: " + smap.get(num).getTitle() + " / 저자 : " + smap.get(num).getAuthor()); }
		else  if(library.equals(name))  { System.out.println("📖 선택한 도서 정보: " + bmap.get(num).getTitle() + " / 저자 : " + bmap.get(num).getAuthor()); }


	}
}
/*
## 📘 연습문제3) Collection Framework + 중첩 HashMap
패키지명 : com.company.basic014_ex
클래스명 : MapEx003

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
   - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
   - 두 번째 Key : ISBN  
   - Value : BookDTO 객체  

2. DTO 클래스  
   java
   class BookDTO {
       private String title;
       private String author;
       // 생성자, getter/setter, toString()
   }
   

3. 출력하기  
   - 각 지점별 도서 목록 출력  

4. 사용자 입력받기  
   - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  

### 📌 실행 예시 
=== 도서관 전체 목록 ===
📚 서울점
978-11111 | 자바의 정석 | 남궁성
978-22222 | 파이썬 기초 | 홍길동
---------------------
📚 부산점
978-33333 | 자료구조와 알고리즘 | 이순신
978-44444 | 파이썬 심화 | 홍길동
---------------------
지점 이름 입력> 서울점
ISBN 입력> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
*/