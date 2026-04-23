package com.the703.basic010;

public class Score{    // com.the703.basic010 패키지에 설정해주세요
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank;
	   public Score() { rank=""; }
	   public Score(String name, int kor, int eng, int math) { this.name = name; this.kor = kor; this.eng = eng; this.math = math;}
	   
	   public String getName() { return name; }
	   public void setName(String name) { this.name = name; }
	   public int getKor() { return kor; }
	   public void setKor(int kor) { this.kor = kor; }
	   public int getEng() { return eng; }
	   public void setEng(int eng) { this.eng = eng; }
	   public int getMath() { return math; }
	   public void setMath(int math) { this.math = math; }

	   void total() { total=kor+eng+math; }
	   void aver() { aver=total/3.0; }
	   void p() { aver(); p = aver>=70? "합격":"불합격"; }
	   void s() { aver(); s = aver>=95? "장학생":"X"; }
	   void rank() { 
		   aver(); 
		   rank="";
	   for(int i=1;i<=aver/10;i++){ rank+="*"; } }
	   	   
	   public static void info(){ System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
	   		+ "이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\r\n"
	   		+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"); }
	   
	   public void show() {
		   total(); aver(); p(); s(); rank();
		   System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n",name,kor,eng,math,total,aver,p,s,rank);
	   }
	   
	} // java011_ex에 설정해주세요!