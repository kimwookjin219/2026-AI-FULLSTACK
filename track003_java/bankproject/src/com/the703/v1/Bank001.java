package com.the703.v1;

import java.util.Scanner;

public class Bank001 {
	public static void main(String[] args) {
		//변수
		int num, id, pass, age;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("WELCOME! (주)CODEJOHNS_BANK");
		
		System.out.println("=======BANK=======");
		System.out.println("* 1.추가");
		System.out.println("* 2.조회");
		System.out.println("* 3.입금");
		System.out.println("* 4.출금");
		System.out.println("* 5.삭제");
		System.out.println("* 9.종료");
		
		System.out.print("입력>>> "); num = sc.nextInt();
		
		System.out.print("ID : "); id = sc.nextInt();
		System.out.print("PASS : "); pass = sc.nextInt();
	}

}
