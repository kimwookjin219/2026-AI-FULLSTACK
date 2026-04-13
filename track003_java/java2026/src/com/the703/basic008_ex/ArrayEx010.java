package com.the703.basic008_ex;

public class ArrayEx010 {
	public static void main(String[] args) {
		int [] su = {-3,-5,-1,-9,-7}; // 0 1 2 3 4
		int rank=1;

	}
}
/*
su[4]요소의 등수를 구하시오.
int [] su = {-3,-5,-1,-9,-7};
int rank=1;

su[0]이 su[1]보다 작으면 rank 1증가  
su[0]이 su[2]보다 작으면 rank 1증가
su[0]이 su[3]보다 작으면 rank 1증가
su[0]이 su[4]보다 작으면 rank 1증가

 for(int i=1;i<=4;i++) { if(su[0]<su[i]) {su[0]=rank++;} }
 for(int i=2;i<=4;i++) { if(su[1]<su[i]) {su[1]=rank++;} }
 for(int i=3;i<=4;i++) { if(su[2]<su[i]) {su[2]=rank++;} }
 for(int i=4;i<=4;i++) { if(su[3]<su[i]) {su[3]=rank++;} }
 
 for(int a=1;a<=4; a++) { for(int i=a;i<=4;i++) { if(su[a]<su[i]) {su[a]=rank++;} } }


*/