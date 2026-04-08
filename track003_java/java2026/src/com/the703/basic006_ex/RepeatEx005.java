package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {
	public static void main(String[] args) {
		int num1=0,num2=0,hap=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1입력 : "); num1 = sc.nextInt();
		System.out.print("숫자2입력 : "); num2 = sc.nextInt();
		
		for(int i=num1;i<=num2;i++) { System.out.print( ( i==num1? "":"+"  )+ i + ( i==num2? "=":"" ) );  hap+=i; }	
		System.out.println(hap);
		
		int i=num1,hap1=0;
		while(i<=num2) { System.out.print( ( i==num1? "":"+"  )+ i + ( i==num2? "=":"" ) );  hap1+=i; i++; }
		System.out.println(hap1);
		
		int i1=num1,hap2=0;
		do { System.out.print( ( i1==num1? "":"+"  )+ i1 + ( i1==num2? "=":"" ) );  hap2+=i1; i1++; }
		while(i1<=num2);
		System.out.println(hap2);
	}
}
/*
두개의 숫자를 입력받아 FOR문을 이용하여 다음과 같이 출력하시오.
에시)
숫자1입력 : 2
숫자2입력 : 5
2+3+4+5=14
숫자1~숫자2까지 합을 구해줘
*/