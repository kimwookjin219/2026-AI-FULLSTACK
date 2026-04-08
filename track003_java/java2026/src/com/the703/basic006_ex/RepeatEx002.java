package com.the703.basic006_ex;

public class RepeatEx002 {
	public static void main(String[] args) {
		int hap=0;
		/*
		 hap[3] 0+3         
		 hap[6] (0+3)+6
		 hap[9] (0+3+6)+9
		 if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
		 if(1%3==0) { x }
		 if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
		 if(2%3==0) { x }
		 if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }
		 if(3%3==0) { 0+3 }
		 if (6이 3의 배수라면) {합을 더해주는 변수에 누적}
		 if(6%3==0) { (0+3)+6 }
		 */
		for(int i=1;i<=10;i++) { if(i%3==0) { hap=hap+i; } }
		System.out.println("1~10까지 3의 배수의 합 : "+hap);
		
		int hap1=0;
		int i=1;
		while(i<=10) { if(i%3==0) { hap1=hap1+i; } i++; }
		System.out.println("1~10까지 3의 배수의 합 : " + hap1);
		
		int hap2=0;
		int i1=1;
		do { if(i1%3==0) { hap2=hap2+i1; } i1++; }
		while(i1<=10);
		System.out.println("1~10까지 3의 배수의 합 : " + hap2);
	}
}
/*
연습문제2)  for/while/do while
패키지명 : com.the703.basic006_ex
클래스명 :  RepeatEx002
for , while , do while 3가지 버젼으로 
1~10까지 3의 배수의 합 : 18

추가문제 카운드까지!

힌트)
ver-1) 말로 풀어쓰기!
1이  3의 배수라면  합을더해주변수에누적
2가  3의 배수라면  합을더해주변수에누적
3이  3의 배수라면  합을더해주변수에누적

ver-2) 구조로 변환(제어,반복)
if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }

ver-3) 코드로 변환(2~3개 샘플로 만들기)
int hap=0;
if(1%3==0) { hap+=1; }
if(2%3==0) { hap+=2; }
if(3%3==0) { hap+=3; }
*/