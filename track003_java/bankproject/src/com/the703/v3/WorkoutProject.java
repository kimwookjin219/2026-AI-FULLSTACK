package com.the703.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getters/setters, hashCode/equals)
class WorkoutDto{
	private String id;
	private String pass;
	private double points;
	private List<String> records;
	
	public WorkoutDto() { super();  }
	public WorkoutDto(String id, String pass, double points) { super(); this.id = id; this.pass = pass; this.points = points; }
	public WorkoutDto(String id) { super(); this.id = id;  }
	@Override public String toString() { return "WorkoutDto [id=" + id + ", pass=" + pass + ", points=" + points + "]"; }
	
	@Override public int hashCode() { return Objects.hash(id, pass, points, records); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutDto other = (WorkoutDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(pass, other.pass)
				&& Double.doubleToLongBits(points) == Double.doubleToLongBits(other.points)
				&& Objects.equals(records, other.records);
	}
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public double getPoints() { return points; }
	public void setPoints(double points) { this.points = points; }
	public List<String> getRecords() { return records; }
	public void setRecords(List<String> records) { this.records = records; }
	
} // end WorkoutDto

//2. 기능 클래스
class WorkoutSystem{
	List<WorkoutDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	Scanner sc = new Scanner(System.in);
	int menu = -1;
	public WorkoutSystem() { super(); }
	public WorkoutSystem(List<WorkoutDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	public void menu() { 
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
	    while(menu != 9) {
	        System.out.print("🏃✨ WELCOME TO WORKOUT RECORD SYSTEM ✨🏃\r\n"
	        		+"[1] ➕ 회원 등록 \r\n[2] 🔍 운동 기록 조회 \r\n[3] 🏋️ 운동 기록 추가 \r\n[4] 🗑️ 운동 기록 삭제 \r\n[5] 🚪 회원 탈퇴 \r\n[9] 종료\r\n\r\n"
	        		+ "👉 번호를 선택하세요");
	         menu = sc.nextInt();
	         
	         if(menu == 1) { add(); }
	         else if(menu>=2 && menu<=5)         {
	        	 WorkoutDto find = login();//로그인 확인
	        	 if(find == null) { System.out.println("정보를 확인해주세요"); continue; }
	        	 //각각 메뉴에 맞는 기능 호출
	        	 switch(menu) {
	        	 	case 2: show(find); break;
	        	 	case 3: addRecord(find); break;
	        	 	case 4: deleteRecord(find); break;
	        	 	case 5: usePoints(find); break;
	        	 	//case 9: exit(); break;
	        	 	//default: System.out.println("잘못된 입력입니다."); break;
	        	 }
	         }
	         else if(menu==9) { exit(); }
	    }
	}  
	
	// 회원등록  (add)
	public void add() {
		//변수
		Scanner sc = new Scanner(System.in);
		//입력 - 사용자에게 정보입력받기
		System.out.print("[1]ID   입력> ");	String tid=sc.next(); //아이디 중복검사
		if(users.contains( new WorkoutDto(tid))) { System.out.println("이미 존재하는 아이디입니다."); return;}	
		
		System.out.print("[2]PASS 입력> ");  String tpass=sc.next();
		//처리  list -> add, get, size , remove, contains
		users.add( new WorkoutDto(tid , tpass , 0 ) );
		//출력
		System.out.println("회원 등록 완료!");
	}
	
	// 유저 로그인 - 유저 정보
	WorkoutDto login(){
		//변수
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("[1]ID   입력> ");	String tid=sc.next(); 				
		System.out.print("[2]PASS 입력> ");  String tpass=sc.next();
		//처리
		for(WorkoutDto u : users) {
			if(u.getId().equals(tid) && u.getPass().equals(tpass)) { return u; }
		}		
		return null; 
	}
	
	// 운동기록 조회
	public void show(WorkoutDto user) {
		System.out.printf("ID : %s\nPOINTS : %d\n", user.getId(), user.getPoints());
		System.out.println("운동 기록 : ");
		if(user.getRecords().isEmpty()) { System.out.println("기록이 없습니다."); }
		else                            { 
			for(String record : user.getRecords()) {
				System.out.println("- " + record);
			}
		}
	}
	
	// 운동기록 추가   (get) 
	public void addRecord(WorkoutDto user) {
		
		System.out.print("운동 입력 > "); String record = sc.next();
		user.getRecords().add(record);
		user.setPoints(user.getPoints()+10); // 운동 기록 추가 시 포인트 10점 적립
		System.out.println("운동 기록 추가 완료! 현재 포인트 : " + user.getPoints()); 	
	}
	
	// 운동기록 삭제
	public void deleteRecord(WorkoutDto user) {
		System.out.println("삭제할 운동 입력 > "); String record = sc.next();
		if(user.getRecords().remove(record)) {
			System.out.println("운동 기록 삭제 완료!");
		}
		else { System.out.println("해당 운동 기록을 찾을 수 없습니다."); }
	}
	
	// 회원 탈퇴(remove) - 
	public void usePoints(WorkoutDto user) {
		
		System.out.print("회원탈퇴 하시겠습니까?(Y/N)");  char again = sc.next().charAt(0);
		
		if(again == 'Y' || again == 'y') { users.remove(user); System.out.println("회원탈퇴 완료! 다음에 또 이용해주세요~");  }
	}
	
	// 종료 - void exit(){}
	void exit() { System.out.println("프로그램은 종료합니다."); }
	
}
public class WorkoutProject{
	public static void main(String[] args) {
		
		List<WorkoutDto>  users = new ArrayList<>();
		WorkoutSystem      controller = new WorkoutSystem(users);
		controller.menu();
		
	}
}




