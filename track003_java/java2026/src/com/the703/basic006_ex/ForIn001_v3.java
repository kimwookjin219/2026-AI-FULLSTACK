package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_v3 {
	public static void main(String[] args) {
		//변수
		int kor=-1,eng=-1,math=-1,total=-1;         // step1. 초기값 0~100사이가 아니게
		double avg=-1;                              
		String no=" ",pass=" ",level=" ",jang=" ";
		Scanner sc = new Scanner(System.in);
		for(;;) {
		//입력			
			System.out.print("학번 입력 > "); no=sc.next();
			for(;;) {
				if(kor<0 || kor>100) { 
				System.out.print("국어점수 입력 > "); kor=sc.nextInt(); 
				 }				
				else if(eng<0 || eng>100) { 
				System.out.print("영어점수 입력 > "); eng=sc.nextInt();				
				 }
				else if(math<0 || math>100) {
				System.out.print("수학점수 입력 > "); math=sc.nextInt();				
				}
				else {break;}
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