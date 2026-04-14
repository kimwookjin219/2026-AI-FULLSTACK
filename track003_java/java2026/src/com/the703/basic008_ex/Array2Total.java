package com.the703.basic008_ex;

public class Array2Total {
	public static void main(String[] args) {
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
		String[] pass= new String[5];
		String[] jang= new String[5];
		String[] by= {" "," "," "," "," "};
		int[] rank= new int[5];
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    int[] count= {1,1,1,1,1};
	    
	   
	    
	    System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");

	    for(int i=0;i<aver.length;i++) {
	    	
	    	aver[i]=(kor[i]+eng[i]+mat[i])/3;
	    	   	
	    	pass[i]= aver[i]>=60? (kor[i]<40 || eng[i]<40 || mat[i]<40? "재시험" :"합격"):"불합격";
	    	
	    	for(int a=0; a<aver[i]/10;a++) { by[i]+="*"; }
	    	
	    	if(aver[i]>=95) { jang[i]="장학생"; }
	    	else            { jang[i]="----"; }
	    }
	    
	    for(int i=0;i<aver.length;i++) {
	    	for(int b=0; b<name.length;b++) { 
	    		if(aver[i]<aver[b]) { count[i]+=1; }
	    	}
	    }
	    
	    for(int i=0;i<aver.length;i++) {
	    	System.out.print(name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+aver[i]+"\t"+count[i]+"등"+"\t"+pass[i]+"\t"+jang[i]+"\t"+by[i]+"\n");
	    }

	}
}

/*
aver[0] > aver[0] count 1증가           for(int a=0;a<aver.length;a++) { for(int i=0;i<aver.length;i++) { if(aver[a]>aver[i]){count++;} } }
aver[0] > aver[1] count 1증가  
aver[0] > aver[2] count 1증가  
aver[0] > aver[3] count 1증가
aver[0] > aver[4] count 1증가    

aver/10이 1이면 *
aver/10이 2이면 **
aver/10이 3이면 ***					
aver/10이 4이면 ****


*/


