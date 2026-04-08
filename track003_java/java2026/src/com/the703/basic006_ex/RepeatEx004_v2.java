package com.the703.basic006_ex;

public class RepeatEx004_v2 {
	public static void main(String[] args) {
		char a='\u0000';
		
		for( a='A'; a<='Z' ; a++ ) { 
			if(a%5==0) { System.out.println(); }
			System.out.print(a); 
			}

	}
}
/*
/*
A~Z까지 다음과 같이 출력하시오.
ABCDE
FGHIJ
KLMNO
PQRST
UVWXY
Z
*/