package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004 {
	public static void main(String[] args) {
		int[][] datas = {  
				{10, 10, 10 ,10},             
                {20, 20, 20 ,20},     
                {30, 30, 30 ,30},     
			};  // 3층 4칸                                                          
		int[][] result = new int[datas.length+1][datas[0].length+1]; 
		
		for(int ch=0;ch<datas.length;ch++){for(int kan=0; kan<datas[ch].length;kan++) { result[ch][kan]=datas[ch][kan]; } }
		
		//		result[0][4]=datas[0][0]+datas[0][1]+datas[0][2]+datas[0][3];
		//		result[1][4]=datas[1][0]+datas[1][1]+datas[1][2]+datas[1][3];
		//		result[2][4]=datas[2][0]+datas[2][1]+datas[2][2]+datas[2][3];
		
		for (int ch = 0; ch < datas.length; ch++) {
			for (int kan = 0; kan < datas[ch].length; kan++) {
				result[ch][4] += datas[ch][kan];				
			}
		}
		
		//		result[3][0]= datas[0][0]+datas[1][0]+datas[2][0]+datas[3][0];
		//		result[3][1]= datas[0][1]+datas[1][1]+datas[2][1]+datas[3][1];
		//		result[3][2]= datas[0][2]+datas[1][2]+datas[2][2]+datas[3][2];
		//		result[3][3]= datas[0][3]+datas[1][3]+datas[2][3]+datas[3][3];
		
		
		//		for(int ch=0; ch<datas.length;ch++) { result[3][0]+=datas[ch][0];}
		//		for(int ch=0; ch<datas.length;ch++) { result[3][1]+=datas[ch][1];}
		//		for(int ch=0; ch<datas.length;ch++) { result[3][2]+=datas[ch][2];}
		//		for(int ch=0; ch<datas.length;ch++) { result[3][3]+=datas[ch][3];}
		
		for(int kan=0; kan<result.length;kan++) { 
			for(int ch=0; ch<datas.length;ch++) {			
				result[3][kan]+=datas[ch][kan];
				result[3][4]+=result[ch][kan];
				} 
			}
		
		for(int ch=0;ch<result.length;ch++) { 
			for(int kan=0; kan<result[ch].length; kan++) {
			System.out.printf("%d\t",result[ch][kan]);
				} 
			System.out.println();
			}
		
		
	}
}
/*
연습문제4)  array
패키지명 : ccom.the703.basic008_ex
클래스명 :  Array2Ex004
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

int[][] datas = {  {  10, 10, 10 ,10},             
                  {  20, 20, 20 ,20},     
                  {  30, 30, 30 ,30},     
};  // 3층 4칸                                  
                               
int[][] result = new int[datas.length+1][datas[0].length+1];    

#1. result 에 datas데이터 복사하기
#2. 가로방향누적데이터
#3. 세로방향데이터누적
#4. 총합

출력내용:
10   10   10   10   40   
20   20   20   20   80   
30   30   30   30   120   
60   60   60   60   240   
*/