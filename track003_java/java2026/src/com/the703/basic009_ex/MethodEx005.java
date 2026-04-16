package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx005{ 
	
		public static int process_total(int kor,int eng , int mat) { return (kor+eng+mat); }
	
		public static int process_avg(int total) { return total/3; }
	
		public static String process_pass(float aver , int kor, int eng, int mat) { return ( (aver>=60)? (kor>40 || eng>40 || mat>40 )? "합격": "재시험" :"불합격" ) ;}
		
		public static String process_scholar(float aver) { return ( aver>=95? "장학생":"---"); }
		
		public static String process_star(float aver) {

		String star="";
		for(int a=1;a<=aver/10;a++) { star+="*"; }
		return star;
		}

		public static String process_show(String name,int kor,int eng,int math,int total,float avg,String pass,String jang,String star) 
		{
			return (name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+pass+"\t"+jang+"\t"+star+"\n");
		}
		
	   public static void main(String[] args) {
	   /////////////////////(1)  변수
			String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
			String[] pass= new String[5];
			String[] jang= new String[5];
			String[] by= {" "," "," "," "," "};
			int[] rank= new int[5];
		    int[] kor={100,20,90,70,35};   
		    int[] eng={100,50,95,80,100};
		    int[] mat={100,30,90,60,100};
		    int[] aver=new int[5];
		    int[] total= new int[5];
		    
		    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
		    		+ " 이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\r\n"
		    		+ "--------------------------------------------------------------------------------------------");
	      /////////////////////(3) 처리 : 
		    for(int i=0;i<total.length;i++) {
		      total[i] = process_total(kor[i] , eng[i], mat[i]);    // 1. 총점처리
		      
		      aver[i] = process_avg(total[i]);    //2.  평균처리
	
		      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		      pass[i] = process_pass(aver[i] , kor[i], eng[i], mat[i]);  
		      
		      //////// 4. 평균이 95점이상이면 장학생
		      jang[i] = process_scholar(  aver[i]  ); 
		      
		      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
		      by[i] = process_star(aver[i]);  
		      
		      /////////////////////(4) 출력
		      System.out.println(process_show(name[i], kor[i], eng[i], mat[i], total[i], aver[i], pass[i], jang[i], by[i])); 
		    }// end for
	      
	   }// end main
	 
	   
	}// end class
/*
연습문제4)  method
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx004

public class MethodEx004{ 
   public static void main(String[] args) {
   /////////////////////(1)  변수
      String name  = ""; 
      int kor, eng, math, total ;
      float avg = 0.0f; 
      String pass = "";
      String jang = "";
      String star= "";  
      Scanner scanner = new Scanner(System.in);
      
      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
   
      /////////////////////(3) 처리 : 
      total = process_total(kor , eng, math);    // 1. 총점처리
      
      avg = process_avg(total);    //2.  평균처리
      
      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
      pass = process_pass(avg , kor, eng, math);  
      
      //////// 4. 평균이 95점이상이면 장학생
      jang = process_scholar(  avg  ); 
      
      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      star = process_star(avg);  
      
      
      /////////////////////(4) 출력
      process_show(name, kor, eng, math, total, avg, pass, jang, star);
    
      
   }// end main
 
   
}// end class

 
      ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
      이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
      --------------------------------------------------------------------------------------------
      아이언맨   100   100   100   300    100.0    합격      장학생   **********
      --------------------------------------------------------------------------------------------
*/