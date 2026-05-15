package com.the703.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getters/setters, hashCode/equals)
//class BankDto{
//	private String id;
//	private String pass;
//	private double balance;
//	
//	
//	public BankDto() { super(); }
//
//	public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }
//
//	public String getId() { return id; }
//	public void setId(String id) { this.id = id; }
//	public String getPass() { return pass; }
//	public void setPass(String pass) { this.pass = pass; }
//	public double getBalance() { return balance; }
//	public void setBalance(double balance) { this.balance = balance; }
//
//	@Override public int hashCode() { return Objects.hash(id); }
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BankDto other = (BankDto) obj;
//		return Objects.equals(id, other.id);
//	}
//} // end BankDto
//
////2. 기능 클래스
//class Bank{
//	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
//	Scanner sc = new Scanner(System.in);
//	int menu = -1;
//	public Bank() { super(); }
//	public Bank(List<BankDto> users) { super(); this.users = users; }
//	
//	// 메뉴 - 안에 내용작성
//	public void menu() {
//		while(menu!=9) {
//			System.out.println("👌WELCOME TO BANK SYSTEM👌");
//			System.out.println("[1] ➕계좌 추가");
//			System.out.println("[2] 🔎계좌 조회");
//			System.out.println("[3] 💶입금 하기");
//			System.out.println("[4] 💸출금 하기");
//			System.out.println("[5] ❌계좌 삭제");
//			System.out.println("[9] 🖐종료\n");
//			System.out.print("👉번호를 입력해주세요.>"); menu = sc.nextInt();
//			
//			switch(menu) {
//				case 1: add(); break;
//			    case 2: search(); break;
//			    case 3: deposit(); break;
//			    case 4: withdraw(); break;
//			    case 5: delete(); break;
//			    case 9: System.out.println("프로그램을 종료하겠습니다!"); break;
//			    default: System.out.println("잘못된 숫자 입력입니다."); break;
//			}
//		}
//	}   
//	// 유저추가  (add)
//	public void add() {
//		//변수
//		
//		//입력 - 사용자에게 정보입력받기
//		System.out.print("[1]ID   입력> ");	String id=sc.next();		
//		System.out.print("[2]PASS 입력>");  String pass=sc.next();
//		System.out.print("[3]금액  입력> ");  double balance=sc.nextInt();
//		//처리 
//		users.add( new BankDto(id , pass , balance ) );
//		//출력
//		System.out.println("계좌추가 완료!");
//	}
//	
//	// 유저 로그인 - 유저 정보 BankDto login(){}
//	BankDto login(){ return null; }
//	
//	public void search() {
//		System.out.print("[1]ID   입력> "); String id = sc.next();
//		System.out.print("[2]PASS 입력> "); String pass = sc.next();
//		
//		for(BankDto user : users) {
//			if(user.getId().equals(id) && user.getPass().equals(pass)) {
//				System.out.println("ID : " + user.getId() + "\n잔액 : " + user.getBalance());
//			return; } 		
//		}
//		System.out.println("해당 계좌는 없는 계좌입니다.");
//	}
//	
//	// 입금   (get) - void deposit( BankDto user ){}
//	public void deposit(BankDto user) {
//		System.out.print("[1]ID   입력> "); String id = sc.next();
//		System.out.print("[2]PASS 입력> "); String pass = sc.next();
//			
//			double balance = user.getBalance();
//			
//			if(user.getId().equals(id) && user.getPass().equals(pass)) {
//				System.out.print("입금할 금액 > ");  double tbalance = sc.nextDouble();
//				System.out.println("입금완료! 잔액 : " + (balance += tbalance)); 
//				user.setBalance(balance);
//			return; 
//		}
//	}
//	
//	// 출금   (get) - void withdraw( BankDto user ){}
//	public void withdraw(BankDto user) {
//		System.out.print("[1]ID   입력> "); String id = sc.next();
//		System.out.print("[2]PASS 입력> "); String pass = sc.next();
//			
//			double balance = user.getBalance();
//			
//			if(user.getId().equals(id) && user.getPass().equals(pass)) {
//				System.out.print("출금할 금액 > "); double tbalance = sc.nextDouble();
//				System.out.println(tbalance>balance? "잔액부족! 출금불가" : "출금완료! 현재 잔액 : " + (balance -= tbalance));
//				user.setBalance(balance);
//			return;
//		}
//	}
//	
//	// 유저삭제(remove) - void delete( BankDto user ){}
//	public void delete(BankDto user) {
//				
//			String id = user.getId();
//			String pass = user.getPass();
//			System.out.println("계좌삭제(Y/N)");  char again = sc.next().charAt(0);
//			if(again == 'Y' || again == 'y') { users.remove(id); users.remove(pass);}		
//	}
//	
//	// 종료 - void exit(){}
//	
//}
public class BankCollect {
	public static void main(String[] args) {
		
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
		controller.menu();
		
		//테스트용
//				controller.add();
//				System.out.println(controller.users);
	}
}




