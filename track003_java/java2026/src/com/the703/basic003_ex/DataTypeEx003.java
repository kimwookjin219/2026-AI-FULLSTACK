package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx003 {
	public static void main(String[] args) {
		//GIGO
		//변수
		int year = -1;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.println("태어난 년도를 입력하시오>");
		year = sc.nextInt();
		//처리
		year = (2026-year)+1;
		//출력
		System.out.print("당신의 나이는 "+ year + "살 입니다.\n");
		System.out.println("당신의 나이는 "+ year + "살 입니다.");
		System.out.printf("당신의 나이는 %d살 입니다.", year);

	}
}
