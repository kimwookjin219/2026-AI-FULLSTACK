package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx007 {
	
	public static int max(int a,int b,int c) 
	{
		int max = a;
		if(b>max) {max=b;}
		if(c>max) {max=c;}	
		return max;
	}

	public static void main(String[] args) {
		int a=0,b=0,c=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 1 > "); a = sc.nextInt();
		System.out.print("숫자 2 > "); b = sc.nextInt();
		System.out.print("숫자 3 > "); c = sc.nextInt();
		int res3=max(a,b,c);
		System.out.println("최대값 : " + res3);

	}//end main

}//end class
/*

*/