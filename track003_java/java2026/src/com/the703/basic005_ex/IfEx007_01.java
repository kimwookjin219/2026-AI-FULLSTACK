package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_01 {
	public static void main(String[] args) {
		//변수
		int num1=0,num2=0; 
		String result="";
		char ch = '\u0000';
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("1. 정수를 하나 입력해주세요 > "); num1 = sc.nextInt();
		System.out.print("2. 정수를 하나 입력해주세요 > "); num2 = sc.nextInt();
		System.out.print("3. 연산자를 입력해주세요(+,-,*,/) > "); ch = sc.next().charAt(0); // "a(0)b(1)c(2)"
		//처리
		
		if     (ch == '+') { result += (num1 + num2); }
		else if(ch == '-') { result += (num1 - num2); }
		else if(ch == '*') { result += (num1 * num2); }
		else if(ch == '/') { result += String.format("%.2f", num1/(double)num2); }
		
		//출력                  출력 + 출력
		System.out.println( "" + num1 + ch + num2 + "=" + result);
		
	}
}
/*
연습문제7)  ※ 숙제
패키지명 : com.company.java004_ex
클래스명 :  IfEx007
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/