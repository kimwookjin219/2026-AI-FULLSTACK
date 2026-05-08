package com.the703.basic015;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004 {
	public static void main(String[] args) {
		//(t)->{}  accept  받는 용도
		// void java.util.function.Consumer.accept( T t )
		//Consumer<String>  consumer = (t)->{ System.out.println("Hello:) " + t); }; 
		
		// ver-1 람다식 정리
		//Consumer<String>  consumer = t-> System.out.println("Hello:) " + t ) ;
		
		// ver-2 참조형
		Consumer<String>  consumer = System.out::println;  // Hello는 붙힐 수 없음
		
		consumer.accept("Lambda");
		consumer.accept("뚭");
		
		//()->{return} get 주는 용도
		// T java.util.function.Supplier.get()
		//Supplier<String>  supplier = ()->{ return "Hello"; }; 
		
		// ver-1 람다식 정리
		Supplier<String>  supplier = () ->  "Hello:)" ; 
		
		System.out.println( supplier.get() ); 
		
		// (t)->{ return true; }  test  판단용도
		// boolean java.util.function.Predicate.test( T t )	
		//Predicate<Integer> predicate = (t)->{ return t<0; };
		
		// ver-1 람다식 정리
		Predicate<Integer> predicate = t -> t<0; 
		
		System.out.println(predicate.test(10));
		System.out.println(predicate.test(-10));
		
		// (t) -> { return }  apply  처리하는 용도
		//R java.util.function.Function.apply( T t )
		//Function<String,Integer>  function = (t)->{ return Integer.parseInt(t); };
		
		// ver-1 람다식 정리
		//Function<String,Integer>  function = t -> Integer.parseInt(t);
		
		//ver-2 참조형
		Function<String,Integer>  function = Integer::parseInt;
		
		System.out.println(function.apply("10")+3); //13
		
		// (left,right) -> { return }   applyAsInt
		//int java.util.function.IntBinaryOperator.applyAsInt (int left, int right)
		//IntBinaryOperator  operator = (left,right) -> { return left>right? left:right ; };
		
		//ver-1 람다식
		IntBinaryOperator  operator = (left,right) -> left>right? left:right ;
		
		System.out.println(operator.applyAsInt(10, 3));  // 누가 큰지 판단 (연산)
		System.out.println(operator.applyAsInt(3, 10));  // 누가 큰지 판단
		
	}
}
/*
자바 API 함수형 인터페이스
1.   Consumer  받는용도 
2.   Supplier  제공용도   
3.   Predicate 판단용도
4.   Function  처리용도
5.   Operator  연산용도
*/