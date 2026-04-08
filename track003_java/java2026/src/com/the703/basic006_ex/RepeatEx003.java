package com.the703.basic006_ex;

public class RepeatEx003 {
	public static void main(String[] args) {
		int hap=0,count=0,no=0;
		
		for(int i=1;i<=30;i++) { if(i%3==0 && i%2==0) { System.out.println(++no+". 3의 배수이면서 2의 배수인 숫자 : "+ i); hap+=i; count++; } }
		System.out.println("갯수 : " + count );
		
		System.out.println();
		
		int hap1=0,count1=0,no1=0;
		int i=1;
		while(i<=30) { if(i%3==0 && i%2==0) { System.out.println(++no1 +". 3의 배수이면서 2의 배수인 숫자 : "+ i); hap1+=i; count1++; } i++; }
		System.out.println("갯수 : " + count1 );
		
		System.out.println();
		
		int hap2=0,count2=0,no2=0;
		i=1;
		do { if(i%3==0 && i%2==0) { System.out.println(++no2 +". 3의 배수이면서 2의 배수인 숫자 : "+ i); hap2+=i; count2++; } i++; }
		while(i<=30);
		System.out.println("갯수 : " + count2 );
	}
}
/*
1~30의 범위에서 3의 배수이면서 2의 배수인 숫자와 갯수를 구하는 프로그램을 작성하시오.

힌트)
ver-0 
1~30중에서 3의 배수이면서 2의 배수인 숫자와 갯수

ver-1
힌트)3의 배수이면서 2의 배수인 숫자
3의배수 : a%3==0     3  (6)  9
2의배수 : a%2==0   2 4 (6) 8 10
if(a%3==0 && a%2==0) { a 갯수 카운트 }

ver-2
if
*/