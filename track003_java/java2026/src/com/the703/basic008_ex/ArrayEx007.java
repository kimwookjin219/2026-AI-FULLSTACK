package com.the703.basic008_ex;

public class ArrayEx007 {
	public static void main(String[] args) {
		char [] ch = {'B','a','n','a','n','a'};
		
		System.out.print("{");
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='A' && ch[i]<='Z') { System.out.print( i==0? (char)(ch[i]+32) :"," + (char)(ch[i]+32)); }
			else if(ch[i]>='a' && ch[i]<='z') { System.out.print( i==0? (char)(ch[i]-32) :"," + (char)(ch[i]-32)); }
		}		
		System.out.print("}");
	}
}
/*
대문자 소문자 서로 바꿔서 출력하시오.
char [] ch = {'B','a','n','a','n','a'};
*/