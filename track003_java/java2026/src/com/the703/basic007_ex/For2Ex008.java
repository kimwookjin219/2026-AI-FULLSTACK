package com.the703.basic007_ex;

import java.util.Scanner;

public class For2Ex008 {
	public static void main(String[] args) {
			
		//ver1
		if(1+1==6) { System.out.println(1+"+"+1+"="+6); } 
		if(1+2==6) { System.out.println(1+"+"+2+"="+6); } 
		if(1+3==6) { System.out.println(1+"+"+3+"="+6); } 
		if(1+4==6) { System.out.println(1+"+"+4+"="+6); } 
		if(1+5==6) { System.out.println(1+"+"+5+"="+6); } 
				
		System.out.println();
		
		//ver2
		for(int a=1;a<=6;a++){ if(1+a==6) { System.out.println(1+"+"+a+"="+6); }  }
		for(int a=1;a<=6;a++){ if(2+a==6) { System.out.println(1+"+"+a+"="+6); }  }
		for(int a=1;a<=6;a++){ if(3+a==6) { System.out.println(1+"+"+a+"="+6); }  }
		for(int a=1;a<=6;a++){ if(4+a==6) { System.out.println(1+"+"+a+"="+6); }  }
		for(int a=1;a<=6;a++){ if(5+a==6) { System.out.println(1+"+"+a+"="+6); }  }
		
		System.out.println();
		
		//ver3
		System.out.println("ver-1 for");
		for( int b=1;b<=6;b++ ){ for(int a=1;a<=6;a++){ if(b+a==6) { System.out.println(b+"+"+a+"="+6); }  } }
		
		System.out.println();
		
		System.out.println("ver-2 while");
		int b=1;
		while( b<=6 ){ 
			int a=1;
			while(a<=6){ if(b+a==6) { System.out.println(b+"+"+a+"="+6); } a++; } 
		 b++; } 
		
		System.out.println();
		
		System.out.println("ver-3 do while");
		b=1;
		do { 
			int a=1;
			do{ if(b+a==6) { System.out.println(b+"+"+a+"="+6); } a++; } while(a<=6);
		 b++; } while( b<=6 );
	}
}
/*
두개의 주사위를 전졌을때 눈의 합이 6이 되는
모든 경우의 수를 출력하는 프로그램을 작성하시오.
이중 for, 이중 while, 이중 do while 세가지 버전으로 작성하시오.

1+5=6    (1 더하기 5가 6이니?)  {1+5=6 출력}
2+4=6    2 더하기 4가 6이니?  2+4=6 출력
3+3=6    3 더하기 3가 6이니?  3+3=6 출력
4+2=6    4 더하기 2가 6이니?  4+2=6 출력
5+1=6    5 더하기 1가 6이니?  5+1=6 출력
*/ 