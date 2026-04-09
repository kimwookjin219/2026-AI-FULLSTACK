package com.the703.basic007_ex;

public class For2Ex003_1 {

	public static void main(String[] args) {
		
		//ver1
				System.out.print("#");System.out.println();
				System.out.print("#");System.out.print("#");System.out.println();
				System.out.print("#");System.out.print("#");System.out.print("#");System.out.println();
				System.out.print("#");System.out.print("#");System.out.print("#");System.out.print("#");System.out.println();
				
				System.out.println();
				
				//ver2
				
				for(int i=1; i<=4; i++) { System.out.print( i<=1? "#" : "" ); } System.out.println();
				for(int i=1; i<=4; i++) { System.out.print( i<=2? "#" : "" ); } System.out.println();
				for(int i=1; i<=4; i++) { System.out.print( i<=3? "#" : "" ); } System.out.println();
				for(int i=1; i<=4; i++) { System.out.print( i<=4? "#" : "" ); } System.out.println();
				
				System.out.println();
				
				//ver3
				for(int ch=1;ch<=4;ch++){ for(int i=1; i<=4; i++) { System.out.print( i<=ch? "#" : "" ); } System.out.println(); }

	}

}
