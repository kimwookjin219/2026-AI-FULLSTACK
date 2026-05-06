package com.the703.basic014;

import java.util.Objects;

public class UserDTO{
	//멤버변수
	private static int cnt=0; // 클래스 변수(static) - method area - 각각 X - 공용 
	private final int no;     // final 수정X
	private String email;     // 인스턴스 변수 - heap area - new O - 생성자 O - this
	
	
	//멤버함수                     기본값 - 명시적초기화 - 초기화블록 - 생성자
	// alt + shift + s (생성자, toString, getters/setters)
	public UserDTO() { this.no = ++cnt;  } //유저번호 = 값; 값 1개증가 대입
	public UserDTO(int no, String email) { super(); this.no = no; this.email = email; }
	public UserDTO(String email) { this(); this.email = email; }
	@Override public String toString() { return "UserDTO [no=" + no + ", email=" + email + "]"; }
	
	public static int getCnt() { return cnt; }
	public static void setCnt(int cnt) { UserDTO.cnt = cnt; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public int getNo() { return no; }
	
	//1. 클래스가 맞는지 확인(UserDTO, email/no)
	@Override public int hashCode() { 
		return Objects.hash(email);  // 객체들의 값
	} 
	//2. 객체안의 값이 같은지 확인
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(email, other.email);
	}
	
	
	
}
