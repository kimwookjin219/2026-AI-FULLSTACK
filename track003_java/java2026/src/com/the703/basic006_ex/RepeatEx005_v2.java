package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005_v2 {
	public static void main(String[] args) {
		int num1=0,num2=0,hap=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1입력 : "); num1 = sc.nextInt();
		System.out.print("숫자2입력 : "); num2 = sc.nextInt();
		
	
			for(int i=num2;i>=num1;--i) { System.out.print( ( i==num2? "":"+"  )+ i + ( i==num1? "=":"" ) ); ; }

		System.out.println(hap);

	}
}
/*
hap[5] = 0+5
hap[4] = (0+5)+4
hap[3] = (0+5+4)+3
두개의 숫자를 입력받아 FOR문을 이용하여 다음과 같이 출력하시오.
에시)
숫자1입력 : 5
숫자2입력 : 2
5+4+3+2+1=14
숫자2~숫자1까지 합을 구해줘
*/