package com.the703.basic010_ex;

import java.util.Scanner;

class MyPrice001{
	String name; int price;
	// 1) 모든 클래스는 생성자 - 컴파일러가 기본생성자를 자동생성   MyPrice001()
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품이름 입력 > "); name=sc.next();
		System.out.print("상품가격 입력 > "); price=sc.nextInt();
	};
	
	void show() {
		System.out.println("\n상품정보입니다.");
		System.out.printf("상품이름 : %s /  상품가격 : %d",name,price);
	};
}

public class ClassEx002 {
	public static void main(String[] args) {
		MyPrice001   p1 = new MyPrice001(); //1) new 객체생성 2) name=null, price=0 초기화  3) p1 1번지
        p1.input();  //1번지.input()
        p1.show();	 //1번지.show()

	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Myprice001.class , ClassEx002.class #1
------------------------------------
[HEAP:동적]                            |  [STACK:지역]

1번지: Myprice001 (객체,Object,instance)
{name="입력", price=1, input(),show()}  ←  p1[1번지]
						                   main #2
------------------------------------
*/
//////////////////////////////////////////////////////

/*
연습문제2)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500
*/