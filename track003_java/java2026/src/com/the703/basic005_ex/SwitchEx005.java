package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx005 {
	public static void main(String[] args) {
		//변수
		int a = -1;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("숫자를 입력하시오. > "); a = sc.nextInt();
		//처리+출력
		switch(a%2) {
		case 1: System.out.println("남자"); break;
		case 0: System.out.println("여자"); break;
		}

	}
}
/*
연습문제5)  
패키지명 : com.company.basic005_ex
클래스명 :  SwitchEx005
출력내용 :   switch 이용
      숫자한개 입력받아
      홀수면 남자
      짝수면 여자

*/