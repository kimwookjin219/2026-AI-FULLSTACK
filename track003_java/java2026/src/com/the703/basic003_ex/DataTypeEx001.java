package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx001 {
	public static void main(String[] args) {
		//GIGO
		//변수
		int age = -1;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("당신의 나이를 입력하시오>");
		age = sc.nextInt();
		//처리 X
		//출력
		System.out.print("내 나이는 " + age + "입니다.\n" );
		System.out.println("내 나이는 " + age + "입니다." );
		System.out.printf("내 나이는 %d입니다.", age );

	}
}
