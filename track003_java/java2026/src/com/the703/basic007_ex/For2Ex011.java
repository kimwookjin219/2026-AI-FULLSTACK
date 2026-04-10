package com.the703.basic007_ex;

public class For2Ex011 {
	public static void main(String[] args) {
		int hap=0;
		
		       for(int i=1;i<=10;i++) { System.out.print( (i==1? "": "+" ) + i + (i==10? "=":"")); hap=hap+i; } System.out.print(hap); System.out.println();
		hap=0; for(int i=11;i<=20;i++) { System.out.print( (i==11? "": "+" ) + i + (i==20? "=":"")); hap=hap+i; } System.out.print(hap); System.out.println();
		hap=0; for(int i=21;i<=30;i++) { System.out.print( (i==21? "": "+" ) + i + (i==30? "=":"")); hap=hap+i; } System.out.print(hap); System.out.println();
		
		System.out.println("ver- for");
		for(int a=1;a<=100;a=a+10){ hap=0; for(int i=a;i<=(a+9);i++) { System.out.print( (i==a? "": "+" ) + i + (i==(a+9)? "=":"")); hap=hap+i; } System.out.print(hap); System.out.println(); }
		
		System.out.println("\nver-while");
		int a=1;
		while(a<=100){
		{ hap=0; int i=a;
		while(i<=(a+9)) { System.out.print( (i==a? "": "+" ) + i + (i==(a+9)? "=":"")); hap=hap+i;  i++; } System.out.print(hap); System.out.println();
		} a=a+10; }
		
		
		System.out.println("\nver-do while");
		
		a=1;
		do{
		{ hap=0; int i=a;
		 do{ System.out.print( (i==a? "": "+" ) + i + (i==(a+9)? "=":"")); hap=hap+i;  i++; } while(i<=(a+9));
			 System.out.print(hap); System.out.println();
		} a=a+10; } while(a<=100);
		
	}
}
/*
1~10
11~20
21~30
...
91~100  누적합
이중 for, while, do while 버전으로
*/