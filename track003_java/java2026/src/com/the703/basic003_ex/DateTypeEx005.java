package com.the703.basic003_ex;

import java.util.Scanner;

public class DateTypeEx005 {
	public static void main(String[] args) {
		//GIGO
		//변수
		int kor=-1,eng=-1,math=-1,total=-1; float avg = 0;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("국어점수를 입력하시오."); kor = sc.nextInt();
		System.out.print("영어점수를 입력하시오."); eng = sc.nextInt();
		System.out.print("수학점수를 입력하시오."); math = sc.nextInt();
		//처리
		total = kor + eng + math;
		avg = total/3f;
		//출력
		System.out.println("총점 : " + total );
		System.out.printf("평균 : %.2f" , avg);
		System.out.println("총점 : " + total + "\n평균 : " +avg);
		System.out.print  ("총점 : " + total + "\n평균 : " +avg+ "\n");
		System.out.printf("총점 : %d \n평균 : %.2f",total,avg);

	}
}
