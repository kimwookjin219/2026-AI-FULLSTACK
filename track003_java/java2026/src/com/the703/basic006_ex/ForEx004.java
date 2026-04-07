package com.the703.basic006_ex;

public class ForEx004 {
	public static void main(String[] args) {
		int count=0;
		// 3     3%3=0   1     {i%3=0;}
		// 6     6%3=0   2
		// 9     9%3=0   3
		//만약에 3의배수라면 갯수 1개증가
		//if(a%3==0) { count+1;}
			for(int i=1; i<=10; i++) { 
				if(i%3==0) { count++; }
				}
			System.out.println(count);
			
	}
}
/*
연습문제4)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx004
출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개
*/