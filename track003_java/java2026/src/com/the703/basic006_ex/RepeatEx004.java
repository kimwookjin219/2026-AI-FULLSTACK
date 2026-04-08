package com.the703.basic006_ex;

public class RepeatEx004 {
	public static void main(String[] args) {
		int count=0;
		
		for( char a='A'; a<='Z' ; a++ ) {  System.out.print(a); count++; 
		if(count%5==0) {System.out.println("");} }
		
		System.out.println();
		
		//while
		int count1=0;
		char a1='A';
		while(a1<='Z') { System.out.print(a1); count1++; 
		if(count1%5==0) {System.out.println("");} a1++; }
		
		System.out.println();
		
		//do while
		int count2=0;
		char a2='A';
		do { System.out.print(a2); count2++; 
		if(count2%5==0) {System.out.println("");} a2++; }
		while(a2<='Z');
		
		}		
	}

/*
A~Z까지 다음과 같이 출력하시오.
ABCDE
FGHIJ
KLMNO
PQRST
UVWXY
Z

System.out.print('A')
System.out.print('B')
System.out.print('C')
System.out.print('D')
System.out.print('E') // 5번쨰마다 줄바꿈
System.out.println();

69
75
79
*/