package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004_v1 {

	public static void main(String[] args) {
		int[][] datas = {  
				{10, 10, 10 ,10},             
                {20, 20, 20 ,20},     
                {30, 30, 30 ,30},     
			};  // 3층 4칸                                                          
		int[][] result = new int[datas.length+1][datas[0].length+1]; 
		
		for (int ch = 0; ch < datas.length; ch++) {
			for (int kan = 0; kan < datas[ch].length; kan++) {
				result[ch][kan] += datas[ch][kan];
				result[ch][4] += result[ch][kan];
				result[3][kan] += result[ch][kan];
				result[3][4] += result[ch][kan];
				
			}
		}
		
		//		result[0][4]=result[0][0]+result[0][1]+result[0][2]+result[0][3]
		//		result[1][4]=result[1][0]+result[1][1]+result[1][2]+result[1][3]
		//		result[2][4]=result[2][0]+result[2][1]+result[2][2]+result[2][3]
		//		result[3][4]=result[3][0]+result[3][1]+result[3][2]+result[3][3]
				
		
		System.out.println(Arrays.toString(result[0]));
		System.out.println(Arrays.toString(result[1]));
		System.out.println(Arrays.toString(result[2]));
		System.out.println(Arrays.toString(result[3]));
		
		

	}

}
/*
출력내용:
10   10   10   10   40   
20   20   20   20   80   
30   30   30   30   120   
60   60   60   60   240    
*/
