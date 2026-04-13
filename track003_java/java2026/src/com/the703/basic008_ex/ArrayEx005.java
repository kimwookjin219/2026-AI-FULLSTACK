package com.the703.basic008_ex;

public class ArrayEx005 {
	public static void main(String[] args) {
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int upper = 0 , lower = 0;
		
		for(int i=0; i<ch.length;i++) { 
			if      (ch[i]>='A' && ch[i]<='Z') { upper++; } 
			else if (ch[i]>='a' && ch[i]<='z') { lower++; }
		}
		
		System.out.println("대문자의 갯수 " + upper);
		System.out.println("소문자의 갯수 " + lower);

	}
}
/*
연습문제5)  array
패키지명 : com.the703.basic008_ex
클래스명 :  ArrayEx005
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트
*/