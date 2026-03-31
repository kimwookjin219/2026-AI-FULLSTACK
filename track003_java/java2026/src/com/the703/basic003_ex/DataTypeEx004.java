package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {
	public static void main(String[] args) {
		//GIGO
		//변수
		//기본형 - 실수형 : float, double
		double pi = 3.14;
		//float pi = 3.14f;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("파이값을 입력하시오>");
		pi = sc.nextDouble();
		//처리
		//출력
		System.out.println("파이값은 "+ pi +"입니다."); // 3.1324567
		System.out.print("파이값은 "+ pi +"입니다.\n"); // 3.1234567
		System.out.printf("파이값은 %f입니다.\n", pi);  // 3.1234567
		System.out.printf("파이값은 %.0f입니다.\n", pi);// 3
		System.out.printf("파이값은 %.1f입니다.\n", pi);// 3.1
		System.out.printf("파이값은 %.2f입니다.\n", pi);// 3.12
		System.out.printf("파이값은 %.6f입니다.\n", pi);// 3.123457  
		//%.(소수점 몇째자리까지 출력하고 싶은지)f 끝의 자리에서 반올림
		
		System.out.println(10/3); // 정수/정수 = 정수
		System.out.println(10/3f);// 정수/실수 = 실수
		System.out.println(10f/3);// 실수/정수 = 실수
	}
}
/*
연습문제4)
패키지명 : com.the703.basic003_ex
클래스명 : DataTypeEx004
출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     파이값은 **입니다.
*/