package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Stream003 {
	public static void main(String[] args) {
		Integer[]  ages = {17 , 21, 26 , 45, 18};
		
		Stream<Integer> sages = Arrays.stream(ages);
		
		//Ex1. 짝수만 출력   짝수만 : filter / 각각출력 : forEach
		//boolean java.util.function.Predicate.test( T t )
		sages.filter( t -> t%2 == 0 ) .sorted() .forEach( System.out::print );
		
		System.out.println();
		
		//Ex2. 평균값 처리 (숫자들을 더해서 연산)
		//(t)->{ return }
		//int java.util.function.ToIntFunction.applyAsInt( T value )
		sages = Arrays.stream(ages);
		
		double aver = sages.mapToInt(age -> age)   // IntStream으로 변환
		                   .average()              // 평균 계산     max(최대), min(최소), sum(합), count(갯수)
		                   .orElse(0.0);            // 값이 없으면 0.0
		
		System.out.println(aver);
		
		//Ex3. 제일 나이가 많은 사람
		sages = Arrays.stream(ages);
		
		int max = sages.mapToInt(age -> age).max().orElse(0);
		
		System.out.println(max);
		
		//Ex4. 나이 정렬해서 리스트로
		//Integer[]  ages = {17 , 21, 26 , 45, 18};
		sages = Arrays.stream(ages);
		
		List<Integer> list =Arrays.stream(ages)
				               .sorted()
				               .collect(Collectors.toList());
		
		System.out.println("졍렬된 리스트 : " + list);
		
		//Ex5. 20살 이상만 필터링해서 리스트로 수집(내림차순)
		sages = Arrays.stream(ages);
		//boolean java.util.function.Predicate.test( T t )
		//(t)->{}
		List<Integer> list2 = Arrays.stream(ages).filter(age -> age>=20).sorted((o1,o2) -> Integer.compare(o2, o1)).collect(Collectors.toList());
		
		System.out.println("내림차순으로 정렬된 리스트(20살 이상) : "+list2);
	}
}
