package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx002 {
	public static void main(String[] args) {
		//GIGO
		//변수
		int like = 0;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("좋아하는 수(정수) 입력하시오>");
		like = sc.nextInt();
		//처리 X
		//출력
		System.out.print("좋아하는 숫자는 " + like + "입니다.\n");
		System.out.println("좋아하는 숫자는 " + like + "입니다.");
		System.out.printf("좋아하는 숫자는 %d입니다.", like);

	}
}
