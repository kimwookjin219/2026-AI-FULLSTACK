package com.the703.days;

public class Day016 {
	public static void main(String[] args) {
		int [][] arr = new int [2][3];
		int data=101;
		
		for(int ch=0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++) { 
				arr[ch][kan]=data++; 
				System.out.printf("%d\t",arr[ch][kan]);
				}
			System.out.println();
			}

	}
}

/*
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   101   102   103
   104   105   106  
*/