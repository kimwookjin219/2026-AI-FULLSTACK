package com.the703.days;

public class Day015 {
	public static void main(String[] args) {
		
//		1.  for, while , do while을 이용해서 문제를 풀으시오.
//	     3   2   1
		System.out.println("ver.for");
		for(int i=3;i>=1;i--) { System.out.print(i+"\t"); }
		
		System.out.println("\nver.while");
		int i=3;
		while(i>=1) { System.out.print(i+"\t"); i--; }
		
		System.out.println("\nver.do while");
		i=3;
		do { System.out.print(i+"\t"); i--; }
		while(i>=1);
		
//		2 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★★★
//		★★
//		★
		System.out.println();
		for(int a=3; a>=1; a--)
		{ for(int b=1;b<=a; b++) { System.out.print("★"); } System.out.println(); }
		
//		3.  1차원배열      new 연산자 이용해서 배열만들기
//	    1. 배열명 : arr     
//	    2. 값 넣기 :   A B C        for+length 이용서 값 대입
//	    3. for + length 로 출력 
		
		char[] arr = new char[3];
		char data='A';
		
		for(int c=0;c<arr.length;c++) { arr[c]=data++;}
		
		for(int c=0;c<arr.length;c++) { System.out.print(arr[c]+"\t"); }
		
	}
}
/*
1.  for, while , do while을 이용해서 문제를 풀으시오.
     3   2   1

2 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
★★★
★★
★

3.  1차원배열      new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 :   A B C        for+length 이용서 값 대입
    3. for + length 로 출력 
*/