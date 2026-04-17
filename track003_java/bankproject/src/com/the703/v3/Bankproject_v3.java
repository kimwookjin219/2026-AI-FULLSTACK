package com.the703.v3;

import java.util.Scanner;

public class Bankproject_v3 {

	public static void menu() {		
		System.out.println("👌WELCOME TO BANK SYSTEM👌");
		System.out.println("[1] ➕계좌 추가");
		System.out.println("[2] 🔎계좌 조회");
		System.out.println("[3] 💶입금 하기");
		System.out.println("[4] 💸출금 하기");
		System.out.println("[5] ❌계좌 삭제");
		System.out.println("[9] 🖐종료\n");
		System.out.print("👉번호를 입력해주세요.>");
	}
	
	public static int find() {
		String [] id = new String[3];
		int find = -1;

		for(int i=0;i<id.length;i++) {
		if(id[i]==null) { find=i; } 
			}		
		return find;
	}
	
	
	//////////////////////////////////////////////////
	public static void main(String[] args) {
		String [] id = new String[3];
		String [] pass = new String[3];
		double [] balance = new double[3];
		int num = -1; 
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
		while(menu!=9) {
				menu();
				menu = sc.nextInt();
				
				if(menu==9) { System.out.println("프로그램은 종료합니다."); break; }
				else if(menu==1) { 
				
				System.out.print("[1]ID   입력> "); id[find()]=sc.next();		

				System.out.print("[2]PASS 입력>");  pass[find()]=sc.next();

				System.out.print("[3]금액  입력> ");  balance[find()]=sc.nextInt();	
				
				}
			
			
			

		}//end while
	}//end main
	
	//////////////////////////////////////////////////

}//end class

/*

method를 이용해서 Bank프로젝트 만들기

*/