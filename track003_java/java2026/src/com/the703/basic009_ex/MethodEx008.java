package com.the703.basic009_ex;

public class MethodEx008 {
	
	public static String add(String a,String b) { return "맛있는 "+a+b; }

	public static void main(String[] args) {
		String a = "CHOCO",b="MILK";
		String res = add(a,b);
		System.out.println(res);
	}//end main

}//end class
