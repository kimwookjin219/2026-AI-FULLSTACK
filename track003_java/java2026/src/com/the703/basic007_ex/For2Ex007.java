package com.the703.basic007_ex;

public class For2Ex007 {
	public static void main(String[] args) {
		
		//ver1
		System.out.print(4); System.out.print(4); System.out.print(4); System.out.print(4); System.out.println();
		System.out.print(3); System.out.print(3); System.out.print(3); System.out.println();
		System.out.print(2); System.out.print(2); System.out.println();
		System.out.print(1); System.out.println();
		
		System.out.println();
		
		//ver2
		for(int i=1;i<=4;i++){ System.out.print(4); } System.out.println();
		for(int i=1;i<=3;i++){ System.out.print(3); } System.out.println();
		for(int i=1;i<=2;i++){ System.out.print(2); } System.out.println();
		for(int i=1;i<=1;i++){ System.out.print(1); } System.out.println();
		
		System.out.println();
		
		//ver3
		
		for(int a=4;a>=1;a--){ for(int i=1;i<=a;i++){ System.out.print(a); } System.out.println(); }

	}
}
/*
패키지명 : ccom.the703.basic007
클래스명 :  For2Ex007   (이중for 이용)

4444
333
22
1
*/