package com.the703.days;

import java.util.Scanner;

public class Day014 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 입력(1,2,3) > ");
		int day = scanner.nextInt();
		
//		1. if 버전
//		정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
//		1이라면 1이다, 2라면 2이다, 3이라면 3이다    1,2,3이 아니다
		if     (day==1) { System.out.println("1이다"); }
		else if(day==2) { System.out.println("2이다"); }
		else if(day==3) { System.out.println("3이다"); }
		
//		2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.
		switch(day) {
			case 1: System.out.println("1이다"); break;
			case 2: System.out.println("2이다"); break;
			case 3: System.out.println("3이다"); break;
		}
		
		
//		3. for, while, do while 버전
//		1 2 3 4  
		System.out.println("ver.for");
		for(int i=1; i<=4;i++) { System.out.print(i+"\t"); }
		
		System.out.println("\nver.while");
		int i=1;
		while(i<=4) { System.out.print(i+"\t"); i++; }
		
		System.out.println("\nver.do while");
		i=1;
		do { System.out.print(i+"\t"); i++; } while(i<=4);
		
		System.out.println();

//		4. 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★
//		★★
//		★★★
		
		for(int b=1;b<=3;b++){ for(int a=1;a<=b;a++) { System.out.print("★"); } System.out.println(); }

//		5. 1차원배열  다음에 해당하는 값에서 index를 이용하여 3을 출력해주세요!
//		      int   [] arr2         =    {1,2,3}; 
		int [] arr2 = {1,2,3};
		
		System.out.println(arr2[2]);

//		6. 1차원배열      new 연산자 이용해서 배열만들기
//		    1. 배열명 : arr     
//		    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
//		       for+length 이용해보기
//		    3. for + length 로 출력
		
		double [] arr = new double[5];
		double data= 1.1;
		
		for(int c=0;c<arr.length;c++) { 
			arr[c]=data; data+=0.1;
			System.out.printf("%.1f\t",arr[c]);
		}
		
	
	}
}
/*
Scanner scanner = new Scanner(System.in);
System.out.print("숫자 입력(1,2,3) > ");
int day = scanner.nextInt();

1. if 버전
정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
1이라면 1이다, 2라면 2이다, 3이라면 3이다    1,2,3이 아니다

2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.

3. for, while, do while 버전
1 2 3 4  

4. 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
★
★★
★★★

5. 1차원배열  다음에 해당하는 값에서 index를 이용하여 3을 출력해주세요!
      int   [] arr2         =    {1,2,3}; 


6. 1차원배열      new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
       for+length 이용해보기
    3. for + length 로 출력
*/