package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String[] args) {
		//1. 문자는 저장 시 숫자로 저장/ 출력 시 문자로 출력
		System.out.println("1. " + 'A' + "\t" + (int)'A'); // 'A' 문자
		System.out.println("1. " + 'a' + "\t" + (int)'a'); // "ABC" 문자열
		System.out.println("3. " + "ABC".charAt(0)); // A (0) B (1)
		System.out.println("3. " + "ABC".charAt(1));
		// - 대문자 입력받아서 소문자로 변경프로그램을 작성하시오.
		//변수
		char ch = '\u0000', lower= '\u0000';
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.println("대문자입력> "); 
		ch=sc.next().charAt(0);
		//처리
		// a(97) = A(65) + 32
		//char = char + int
		//2byte= 2byte + 4byte  [|]   [|||]     4칸짜리를 2칸짜리에 넣어야한다 (강제형변환)
		lower = (char) (ch + 32) ;
		//출력
		System.out.println(ch + "를 소문자로 " + lower);
	}
}
/*
연습문제3)
패키지명 : com.the703.basic004_ex
클래스명 : CastingEx003
- 대문자입력받아서 소문자로 변경프로그램을 작성하시오.
*/