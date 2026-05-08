package com.the703.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class User{
	private String Id;
	private String pass;
	private int balcane;
	
	public User() { super();  }
	public User(String id, String pass, int balcane) { super(); Id = id; this.pass = pass; this.balcane = balcane; }
	@Override public String toString() { return "User [Id=" + Id + ", pass=" + pass + ", balcane=" + balcane + "]"; }
	
	public String getId() { return Id; }
	public void setId(String id) { Id = id; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public int getBalcane() { return balcane; }
	public void setBalcane(int balcane) { this.balcane = balcane; }
	
	@Override public int hashCode() { return Objects.hash(Id, balcane, pass); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id) && balcane == other.balcane && Objects.equals(pass, other.pass);
	}
}

public class Bankproject_v3 {
	public static void main(String[] args) {
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
		List<User> list = new ArrayList<>();
		
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
			if(menu==9) { System.out.println("프로그램은 종료합니다."); break; }
			
			else if(menu==1) {
				
//				System.out.print("[1]ID   입력> ");	list.add()=sc.next();		
//				System.out.print("[2]PASS 입력>");  pass=sc.next();
//				System.out.print("[3]금액  입력> ");  balance=sc.nextInt();	
			}
			
		}//end while
	}//end main
}//end class

/*

콜렉션 프레임 워크로 작성한 ArrayList 버전

*/