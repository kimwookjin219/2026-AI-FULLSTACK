package com.the703.v1;

import java.util.Scanner;

public class Bankproject_while {

	public static void main(String[] args) {
		//변수
		int menu=-1;
		int id = -1, pass = -1 , balance=-1 ,in=-1,out=-1;
		char ch = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		//입력 처리 출력
		//for (;menu!=9;) { }
		while(menu!=9) {
			//System.out.println(id+"\t"+pass+"\t"+balance); // 계좌 1명분 (확인용)
			System.out.println("👌WELCOME TO BANK SYSTEM👌");
			System.out.println("[1] ➕계좌 추가");
			System.out.println("[2] 🔎계좌 조회");
			System.out.println("[3] 💶입금 하기");
			System.out.println("[4] 💸출금 하기");
			System.out.println("[5] ❌계좌 삭제");
			System.out.println("[9] 🖐종료\n");
			
			System.out.print("👉번호를 입력해주세요.>"); menu = sc.nextInt();
			
			
			if(menu==9) { System.out.println("프로그램은 종료합니다."); }
			else if(menu==1) { 
				//변수 X
				//입력
				System.out.print("[1]ID   입력> "); id=sc.nextInt();
				System.out.print("[2]PASS 입력>"); pass=sc.nextInt();
				System.out.print("[3]금액  입력> "); balance=sc.nextInt();
				//처리 출력 X
				}				
			else if(menu>=2 && menu<=5) { 
				int tid =-1,tpass =-1;
				//입력
				System.out.print("[1]ID   입력> "); tid = sc.nextInt();
				System.out.print("[2]PASS 입력> "); tpass = sc.nextInt();
				
				// if(id==tid && pass==tpass) { continue; }
				if(id!=tid || pass!=tpass) { System.out.println("다시 확인 해주세요."); continue; }
				
				switch(menu) {
					case 2: System.out.printf("ID : %d\nPASS : %d\nBALANCE : %d\n",id,pass,balance); break;
					case 3: System.out.print("입금할 금액 > ");   balance += sc.nextInt(); break;
					case 4: System.out.println("출금할 금액 > "); int tbalance = sc.nextInt(); 
							System.out.println(tbalance>balance? "잔액부족! 출금불가" : "출금완료! 현재잔액"  + (balance -=tbalance ) );
							break;
					case 5: System.out.println("계좌삭제(Y/N)");  char again = sc.next().charAt(0);
							if(again == 'Y' || again == 'y') { id=-1; pass=-1;}
							break;					
					} // end switch		
				
			} // end else if(menu>=2 && menu<=5)			
		} // end while		
	} // end main
} //end class

/*
while(메뉴!=9) {
	0.메뉴판 입력
	
	if     (메뉴==9) { [9] 종료  }
 	else if(메뉴==1) {1.[1] 계좌추가 }
 	else {[2~5] 
 			2-1. 사용자가 맞는지 여부
	 			임시 아이디 입력받기  >
	 			임시 비밀번호 입력받기 >
	 			저장되어 있는 아이디와 임시 아이디가 같고 저장되어있는 비밀번호와 임시 비밀번호가 같으면 아래 내용 처리
 			2-2. 조회면 조회,입금이면 입금,출금이면 출금 .....
 			swich(메뉴) {
 			case 2: 조회처리   break;
 			case 3: 입금받기 / 잔액에 입금받고 추가 break;
 			case 4: 출금받기 / 잔액에 출금한돈 뺴기 ( 마이너스 통장X, 잔액없으면 출금안되게 ) break;
 			case 5: 계좌삭제여부 Y를 입력받으면 계좌 삭제 / N break;
 			}
 		}	
}
*/