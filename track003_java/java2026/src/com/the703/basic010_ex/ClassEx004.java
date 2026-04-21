package com.the703.basic010_ex;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)

class TV{
	//상태 - 멤버변수 : 채널/볼륨
	String channel; int volume;
		
	public TV() { super();  } //디폴트생성자

	public TV(String channel, int volume) { super(); this.channel = channel; this.volume = volume; }

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("channel입력>"); channel = sc.next();
		System.out.print("volume 입력>"); volume = sc.nextInt();
	}
	
	void show() {
		System.out.println(channel + "\t" +volume);
	}
}

public class ClassEx004 {
	public static void main(String[] args) {
		   TV  t1 = new TV("JDBC" , 8);
		   t1.show(); 
		   TV  t2 = new TV();
		   t2.input();  
		   t2.show();

	}
}
/*
연습문제2)  class
패키지명 : com.the703.basic010_ex_ex
클래스명 :  ClassEx004
-- 생성자 작성하시오.
class TV{
//상태-멤버변수  : 채널/볼륨 String channel; int volume;   
//행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
}
public class ClassEx004 {
    public static void main(String[] args) {
   TV  t1 = new TV("JDBC" , 8);
   t1.show(); 
   TV  t2 = new TV();
   t2.input();  
   t2.show();
   }
}
출력내용 :
JDBC   8

* channel입력>youtube
* volume 입력>10
youtube   10
*/