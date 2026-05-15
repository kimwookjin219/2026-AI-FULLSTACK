package com.the703.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getters/setters, hashCode/equals)
class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	
	public BankDto() { super(); }

	public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }

	@Override public int hashCode() { return Objects.hash(id); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return Objects.equals(id, other.id);
	}
} // end BankDto

//2. 기능 클래스
class Bank{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	Scanner sc = new Scanner(System.in);
	int menu = -1;
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	public void menu() { 
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
	    while(menu != 9) {
	        System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
	               + "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n"
	               + "👉 번호를 선택하세요:");
	         menu = sc.nextInt();
	         
	         if(menu == 1) { add(); }
	         else          {
	        	 BankDto find = login();//로그인 확인
	        	 if(find == null) { System.out.println("정보를 확인해주세요"); continue; }
	        	 //각각 메뉴에 맞는 기능 호출
	        	 switch(menu) {
	        	 	case 2: show(find); break;
	        	 	case 3: deposit(find); break;
	        	 	case 4: withdraw(find); break;
	        	 	case 5: delete(find); break;
	        	 	case 9: exit(); break;
	        	 	default: System.out.println("잘못된 입력입니다."); break;
	        	 }
	         }
	    }
	}  
	
	// 유저추가  (add)
	public void add() {
		//변수
		Scanner sc = new Scanner(System.in);
		//입력 - 사용자에게 정보입력받기
		System.out.print("[1]ID   입력> ");	String tid=sc.next(); //아이디 중복검사
		//if(users.contains(tid)) { System.out.println("이미 존재하는 아이디입니다."); }	
		
		System.out.print("[2]PASS 입력> ");  String tpass=sc.next();
		System.out.print("[3]금액  입력> ");  double tbalance=sc.nextInt();
		//처리  list -> add, get, size , remove, contains
		users.add( new BankDto(tid , tpass , tbalance ) );
		//출력
		System.out.println("계좌추가 완료!");
	}
	
	// 유저 로그인 - 유저 정보 BankDto login(){}
	BankDto login(){
		//변수
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("[1]ID   입력> ");	String tid=sc.next(); 				
		System.out.print("[2]PASS 입력> ");  String tpass=sc.next();
		//처리
		for(BankDto u : users) {
			if(u.getId().equals(tid) && u.getPass().equals(tpass)) { return u; }
		}		
		return null; 
	}
	
	// 계좌조회
	public void show(BankDto user) {
		System.out.printf("ID : %s\nPASS : %s\nBALANCE : %.1f\n",user.getId(),user.getPass(),user.getBalance());
	}
	
	// 입금   (get) - void deposit( BankDto user ){}
	public void deposit(BankDto user) {
		double balance = user.getBalance();
		
		System.out.print("입금금액 > "); double tbalance = sc.nextDouble();
		System.out.println("입금완료! 잔액 : " + ( balance += tbalance)); 
		user.setBalance(balance);
	}
	
	// 출금   (get) - void withdraw( BankDto user ){}
	public void withdraw(BankDto user) {
		double balance = user.getBalance();
		
		System.out.print("출금금액 > "); double tbalance = sc.nextDouble();
		if(user.getBalance() < tbalance ) { System.out.println("잔액이 모자랍니다."); return; }
		System.out.println("출금완료! 잔액 : " + ( balance -= tbalance)); 
		user.setBalance(balance);
	}
	
	// 유저삭제(remove) - void delete( BankDto user ){}
	public void delete(BankDto user) {
		
		System.out.print("계좌삭제(Y/N)");  char again = sc.next().charAt(0);
		
		if(again == 'Y' || again == 'y') { users.remove(user); System.out.println("삭제완료!");  }
	}
	
	// 종료 - void exit(){}
	void exit() { System.out.println("프로그램은 종료합니다."); }
	
}
public class Bankproject_v3 {
	public static void main(String[] args) {
		
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
		controller.menu();
		
		//테스트용
//				controller.add();
//				System.out.println(controller.users);
	}
}




