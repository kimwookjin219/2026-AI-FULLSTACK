package com.the703.basic008_ex;

public class Array2Ex002 {
	public static void main(String[] args) {
		int [][] arr = new int[2][3];
		int data=101;
		
		//		arr[0][0]=data;   data+=1;
		//		arr[0][1]=data;   data+=1;
		//		arr[0][2]=data;   data+=1;
		//		arr[1][0]=data;   data+=1;
		//		arr[1][1]=data;   data+=1;
		//		arr[1][2]=data;   data+=1;
		//		
		//		for(int kan=0; kan<arr[0].length; kan++) { arr[0][kan]=data;   data+=1; }
		//		for(int kan=0; kan<arr[1].length; kan++) { arr[1][kan]=data;   data+=1; }
		
		for(int ch=0;ch<arr.length;ch++ , data=201) { 
			for(int kan=0; kan<arr[ch].length; kan++) { arr[ch][kan]=data;   data+=1; 
			System.out.printf("%d\t",arr[ch][kan]);
				} 
			System.out.println();
			}
		
		

	}
}
/*
연습문제2)  array
패키지명 : com.the703.basic008_ex
클래스명 :  Array2Ex002
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   101   102   103
   201   202   203
*/