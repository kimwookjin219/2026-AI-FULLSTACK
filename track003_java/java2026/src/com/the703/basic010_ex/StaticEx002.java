package com.the703.basic010_ex;

class Mobile2{
	//멤버변수
    String   serialNo;      //인스턴스 변수 - heap - new O - 생성자 - this(객체)
    static  int count=0;    //클래스변수 - method - new X - 클래스명.변수명
    
    //멤버함수
    Mobile2() { this.serialNo="2030-"+ ++count; }

}
/*           기본값       명시적초기화       초기화블록        생성자
#1 count       0           0             0             X                  method -클래스변수  
#2 serialNo   null        null          null         "2030-" + ++count    heap - this.serialNo
*/
public class StaticEx002 {
	public static void main(String[] args) {
	     Mobile2 m1 = new Mobile2(); //1. new 공간빌리기  2. 생성자()  3. 번지
	     Mobile2 m2 = new Mobile2(); 
	     Mobile2 m3 = new Mobile2();  
	     Mobile2 m4 = new Mobile2();  

	     System.out.println("모바일 갯수는 모두 "+ Mobile2.count +"개 입니다.");   
	     System.out.println("m1의 제품번호 " + m1.serialNo);  //1
	     System.out.println("m2의 제품번호 " + m2.serialNo);  //2
	     System.out.println("m3의 제품번호 " + m3.serialNo);  //3
	     System.out.println("m4의 제품번호 " + m4.serialNo);  //4

	}
}
/*
연습문제2)  static
패키지명 : com.the703.basic010_ex
클래스명 :  StaticEx002
-- class Mobile2   작성해주세요    


class Mobile2{  
      String   serialNo;
      static  int count=0; 
} 

public class StaticEx002{
  public static void main(String[] args) {
     Mobile2 m1 = new Mobile2(); //1. new 공간빌리기  2. 생성자()  3. 번지
     Mobile2 m2 = new Mobile2(); 
     Mobile2 m3 = new Mobile2();  
     Mobile2 m4 = new Mobile2();  

     System.out.println("모바일 갯수는 모두 "+ Mobile2.count +"개 입니다.");   
     System.out.println("m1의 제품번호 " + m1.serialNo);  //1
     System.out.println("m2의 제품번호 " + m2.serialNo);  //2
     System.out.println("m3의 제품번호 " + m3.serialNo);  //3
     System.out.println("m4의 제품번호 " + m4.serialNo);  //4
  }
}

출력된결과:
모바일 갯수는 모두 4개 입니다.
m1의 제품번호 2030-1
m2의 제품번호 2030-2
m3의 제품번호 2030-3
m4의 제품번호 2030-4
*/