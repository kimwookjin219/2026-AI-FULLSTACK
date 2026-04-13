package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx006 {
	public static void main(String[] args) {
		char [] ch = new char[52];	
		char ch1='A';
		char ch2='a';
		int count=0;
		
		for(int i=0;i<26;i++) { 
			ch[i]=ch1; ch1=(char)(ch1+1);
			ch[i+26]=ch2; ch2=(char)(ch2+1);				
		}
		System.out.println(Arrays.toString(ch));
		
		for(int i=0; i<ch.length;i++) {
		if(ch[i]=='A' || ch[i]=='A'+4 || ch[i]=='A'+8 || ch[i]=='A'+12 || ch[i]=='A'+20 ||
		   ch[i]=='a' || ch[i]=='a'+4 || ch[i]=='a'+8 || ch[i]=='a'+12 || ch[i]=='a'+20 )
		 { count++; }
		}
		
		System.out.println(count);
	}
}
/*
1.new를 이용하여 문자열 배열 ch 52개 만드시오.
2.대문자 A~Z, a~z까지 52개의 데이터를 for를 이용하여 ch배열에 데이터를 대입하시오.
3. for문을 이용하여 모음의 갯수를 구하시오.

>> 모음 : a,e,i,o,u,A,E,I,O,U

A 65      a 97
E 69      e 101
I 73      i 105
O 79      o 111
U 85      u 117

*/