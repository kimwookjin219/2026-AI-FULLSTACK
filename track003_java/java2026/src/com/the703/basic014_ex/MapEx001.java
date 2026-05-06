package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key1 = "";
		
		Map<String, String> map = new HashMap<>();
		map.put("피구왕" , "통키");
		map.put("제빵왕" , "김탁구");
		map.put("요리왕" , "비룡");
		
		System.out.println("==============================\r\n"
				+ "KING\tNAME\r\n"
				+ "==============================");
		
		for( Entry<String, String> u : map.entrySet() ) { 
			String key = u.getKey();
			String value = u.getValue();
			
			System.out.println( key + "\t" + value );
			System.out.println("---------------------");
		}
		

		System.out.println("KING의 정보를 제공중입니다.");
		System.out.print("이름을 입력하세요> "); key1 = sc.next();
		// System.out.println( map.contains(key1) ? "ㅁ" + key1 + " : " + map.get(key1) : "찾으시는 왕이 없습니다." );
		
		if(map.containsKey(key1)) { System.out.println("ㅁ"+ key1 +" :" + map.get(key1) + "\n" ); }	
		
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : MapEx001
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
2-1. 다음과 같이 출력
2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구
*/