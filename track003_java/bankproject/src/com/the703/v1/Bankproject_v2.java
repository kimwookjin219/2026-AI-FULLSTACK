package com.the703.v1;

import java.util.Scanner;

public class Bankproject_v2 {

	public static void main(String[] args) {
		//변수
				int num1=-1;
				int id = -1, pass = -1 , balance=-1 ,in=-1,out=-1;
				char ch = '\u0000';
				Scanner sc = new Scanner(System.in);
				//입력
				for(;;) {		
					System.out.println("👌WELCOME TO BANK SYSTEM👌");
					System.out.println("[1] ➕계좌 추가");
					System.out.println("[2] 🔎계좌 조회");
					System.out.println("[3] 💶입금 하기");
					System.out.println("[4] 💸출금 하기");
					System.out.println("[5] ❌계좌 삭제");
					System.out.println("[9] 🖐종료\n");
					
					System.out.print("👉번호를 입력해주세요.>"); num1 = sc.nextInt();
					
					if     ( num1==1 ) {
						System.out.println("1.추가 \n"); 
						//입력    int id = -1, pass = -1 , balance=-1 ;
						System.out.print("[1]ID   입력> "); id = sc.nextInt();
						System.out.print("[2]PASS 입력> "); pass = sc.nextInt();
						System.out.print("[3]금액  입력> "); balance = sc.nextInt();				
						} // if( num1==1 ) end
					
					else if ( num1==2 || num1==3 || num1==4 || num1==5 ) {
						
	
						int tid =-1,tpass =-1;
						//입력
						System.out.print("[1]ID   입력> "); tid = sc.nextInt();
						System.out.print("[2]PASS 입력> "); tpass = sc.nextInt();
						//처리+출력
						
						if(tid==id && tpass==pass) { 
						
							if      (num1==2) { System.out.println("잔액 : " + balance + "\n"); }
							
							else if (num1==3) { System.out.print("입금 : "); in = sc.nextInt();
		                    					System.out.println("==입금완료");
		                    					System.out.println("잔액 : " + (balance+in) ); }
							
							else if (num1==4)  { System.out.print("출금 : "); out = sc.nextInt();
													if((balance-out)>0) { System.out.println("==출금완료");
													 System.out.println("잔액 : " + (balance-out)); }
													else { System.out.println("출금이 불가능 합니다."); }
												  }
							
							else if (num1==5) { 
									System.out.print("계좌를 삭제하시겠습니까? Y / N "); ch = sc.next().charAt(0);
									switch(ch) {
										case 'Y': case 'y': id = -1;  pass = -1; System.out.println("계좌가 삭제되었습니다."); break;
										case 'N': case 'n': System.out.println(); break;
									} // end switch								
								} 
							
							} // end tid==id && tpass==pass 
								
						else                       { System.out.println("다시 확인해주세요."); }							 					
					} // else if ( num1==2 || num1==3 || num1==4 || num1==5 ) end
					
					else if( num1==9 ) {
						System.out.println("종료하겠습니다."); break; 
						} // num1==9 end
					
				} // end for(;;)
				
	} // end main

} // end class
/*
  
  ver-1
-조건문 : if , switch
-반복문 : for(시작;종료;변화), while(조건), do while(한번은 무조건 실행하고 나중에 조건을 볼게)
                       무한반복은 while을 추천

 무한반복(종료:9) {
 	0.메뉴판 입력
 	1.[1] 계좌추가
 	2.[2~5] 
 		2-1. 사용자가 맞는지 여부
 		2-2. 조회면 조회,입금이면 입금,출금이면 출금 .....
 	3.[9] 종료  	
	} 

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



