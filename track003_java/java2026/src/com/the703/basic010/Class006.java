package com.the703.basic010;

//1. final 변경하지마
//1) 클래스는 부품객체
//2) 클래스(상속:X)는 상태(멤버변수:상수)와 행위(멤버함수:)
//final  class 재사용하지마 - 상속 X
class FinalEx extends Object{
	static final String child="5-5";  // 클래스변수 - method area - new X - this X
	String name; // 인스턴스변수 - heap area - new O - 생성자 O - this(각각)
  /*final*/void show() { System.out.println(child + "\t" + name); } //인스턴스 메서드
}
class FinalExSon extends FinalEx{
	@Override void show() { System.out.println("나한테 맞게 수정"); }
}
//class Test extends Color{}
public class Class006 {
	public static void main(String[] args) {
		//FinalEx.child = "5-12";  
		//The final field FinalEx.child cannot be assigned

	}
}
/*
final (하지마)

1) 클래스  ( 상속 X - 재사용(extends) 사용못함)
2) 멤버변수 (상수 O / 값 변경 X )
3) 멤버함수 ( 부모기능 수정X / @Override 못함 )
*/
