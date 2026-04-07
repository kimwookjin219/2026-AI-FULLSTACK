package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_v2 {
	public static void main(String[] args) {
		//변수
		int kor=-1,eng=-1,math=-1,total=-1;         // step1. 초기값 0~100사이가 아니게
		double avg=-1;                              
		String no=" ",pass=" ",level=" ",jang=" ";
		Scanner sc = new Scanner(System.in);
		for(;;) {
		//입력			
			System.out.print("학번 입력 > "); no=sc.next();
			for(;;) {// step5. 다시 검색
				//if (국어점수의 범위가 아니라면) { // step2. kor = -1
				if(kor<0 || kor>100) {   // !(kor>=0 && kor<=100) : 0~100사이가 아니면
				//1. 입력받기
				System.out.print("국어점수 입력 > "); kor=sc.nextInt(); // step3
				//2.건너뛰기
				continue; //step4
				 }
				
				if(eng<0 || eng>100) { 
				System.out.print("영어점수 입력 > "); eng=sc.nextInt();
				continue;
				 }
				
				if(math<0 || math>100) {
				System.out.print("수학점수 입력 > "); math=sc.nextInt();				
				
				continue;
				}
				//break; 나오기 - 여기까지 왔으면 잘 입력한것!
				break;
			}	
								
					
			//처리
			total = kor+eng+math;
			avg = (double)total/3;
			pass = avg<60? "불합격" : (kor<40 || eng<40 || math<40)?  "불합격" : "합격";
			jang = avg>=95? "장학생" : "X";
			level = avg>=90? "수"
					: avg>=80? "우"
					: avg>=70? "미"
					: avg>=60? "양" : "가";		
			//출력
			System.out.println("====================================================================");
			System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
			System.out.println("====================================================================");
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n",no,kor,eng,math,total,avg,pass,level,jang);
			System.out.println();
		 	}
		}
	}

/*
연습문제1)   
패키지명 : com.company.java004_ex
클래스명 :   ForIn001
출력내용 :  성적처리 프로그램입니다.

0. 국어,영어, 수학(0~100만입력받기)  
1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100  
수학점수 입력 > 100
영어점수 입력 > 99
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/