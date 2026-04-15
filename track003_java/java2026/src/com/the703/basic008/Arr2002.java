package com.the703.basic008;

public class Arr2002 {
	public static void main(String[] args) {
		//1. 초기값을 알고 있는 경우
		int [][] arr2 = {
				{1,2,3} , // 00 01 02    층칸
				{4,5,6} , // 10 11 12	 층칸		
		};
		
		//2. 값을 모르는 경우
		int [][] arr21 = new int[2][3]; 
		int data=10;
		// new 메모리 빌려오기    int(자료형) 2층 3칸
		//ver-2
		//		arr21[0][0] =  data; data+=10;
		//		arr21[0][1] =  data; data+=10; 
		//		arr21[0][2] =  data; data+=10;
		//		arr21[1][0] =  data; data+=10;
		//		arr21[1][1] =  data; data+=10;
		//		arr21[1][2] =  data; data+=10;
		
		//ver-3
		//		for(int kan1=0;kan1<arr21[0].length;kan1++) { arr21[0][kan1]=data; data+=10; }
		//		for(int kan1=0;kan1<arr21[1].length;kan1++) { arr21[1][kan1]=data; data+=10; }
		
		//ver-4
		for(int ch1=0;ch1<arr21.length;ch1++) { // 배열명.length 몇층
			for(int kan1=0;kan1<arr21[ch1].length;kan1++) { // 배열명[0].length 0층 몇칸
				arr21[ch1][kan1]=data; data+=10; 
				}
			//끝나고 해야할 일
		}
		
		for(int ch=0;ch<arr21.length;ch++) { //배열의 층수
			for(int kan=0;kan<arr21[ch].length;kan++) { //배열[층]의 칸수
				System.out.print(arr21[ch][kan]+"\t");
			}
			//2-3 한층이 끝나면 해야할일
			System.out.println();
		}
		
		
		
		

	}
}
