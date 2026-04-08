package com.the703.basic006;

public class WhileBasic {
	public static void main(String[] args) {
		// for  1 2 3출력
		// {반복} {변수}  for(시작;종료;변화)
		System.out.println("ver-0");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		
		
		System.out.println("\n"+"ver-1 for");
		for(int i=1;i<=3;i++) { System.out.print(i+"\t"); }
		
		
		//while
		System.out.println("\n"+"ver-2 while");
		int i=1;
		while( i<=3 ) { System.out.print(i+"\t");    i++; }
		
		//do while
		System.out.println("\n"+"ver-3 do while");
		int i1=1;
		 do { System.out.print(i1+"\t");    i1++; }
		 while( i1<=3 );
	}
}
