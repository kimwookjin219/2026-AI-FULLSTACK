package com.the703.basic007_ex;

public class For2Ex002 {

	public static void main(String[] args) {
		
		//ver1
		System.out.print("@"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("@"); System.out.print("#"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.print("@"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("@"); System.out.println();
		
		System.out.println();
		
		//ver2
		
		for(int i=1;i<=4;i++) { System.out.print( i==1? "@" : "#" ); } System.out.println();
		for(int i=1;i<=4;i++) { System.out.print( i==2? "@" : "#" ); } System.out.println();
		for(int i=1;i<=4;i++) { System.out.print( i==3? "@" : "#" ); } System.out.println();
		for(int i=1;i<=4;i++) { System.out.print( i==4? "@" : "#" ); } System.out.println();
		
		System.out.println();
		
		//ver3
		for(int ch=1;ch<=4;ch++) { for(int i=1;i<=4;i++) { System.out.print( i==ch? "@" : "#" ); } System.out.println(); }

	}
}
/*
패키지명 : ccom.the703.basic007
클래스명 :  For2Ex002   (이중for 이용)

@###
#@##
##@#
###@

만약 (1층이라면) {첫번째 골뱅이}
만약 (2층이라면) {두번쨰 골뱅이}

*/