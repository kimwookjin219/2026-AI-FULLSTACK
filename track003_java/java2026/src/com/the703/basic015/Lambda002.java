package com.the703.basic015;

////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String   hi(int num , String name); }   
////////////////////////////////////////////////////////////

public class Lambda002 {
	public static void main(String[] args) {
		// interface InterA2{  void   hi(); }
		System.out.println("\n[step1] 매게변수 x 리턴값 x");
		//1-1 익명객체
		InterA2 a1 = new InterA2() {  
			@Override public void hi() { System.out.println("Hi"); }
			};  a1.hi();
		//1-2 lambda ()->{  }
		InterA2 a2 = ()->{ System.out.println("Hi Hi"); }; a2.hi();
		
		InterA2 a3 = ()-> System.out.println("Hi Hi Hi");  a3.hi();  // 처리할 일이 한 줄이면 {} 생략가능
		
		//interface InterB2{  void   hi(String name); }
		System.out.println("\n[step2] 매게변수 o 리턴값 x");
		//2-1 익명객체  hi! sally
		InterB2 b1 = new InterB2() {
			@Override public void hi(String name) { System.out.println("hi!" + name); }  
			}; b1.hi("sally");
		//2-2 lambda ()->{  }
		InterB2 b2 = (String name)->{ System.out.println("hi!" + name); };	b2.hi("alpha");
		
		InterB2 b3 = (name)-> System.out.println("hi!" + name); 	b3.hi("beta");
		
		InterB2 b4 = name -> System.out.println("hi!" + name); 	b4.hi("delta");
		
		//interface InterC2{  String hi(); }
		System.out.println("\n[step3] 매게변수 x 리턴값 o");
		//3-1 익명객체     Good :Day
		InterC2 c1 = new InterC2() {
			@Override public String hi() {  return "Good :Day"; }
			}; System.out.println(c1.hi());
		//3-2 lambda ()->{  }
		InterC2 c2 = ()->{ return "Good :Day!"; };
		System.out.println(c2.hi());
		
		InterC2 c3 = ()-> "Good :Day!!";
		System.out.println(c3.hi());
		
		//interface InterD2{  String   hi(int num , String name); }
		System.out.println("\n[step4] 매게변수 o 리턴값 o");
		//4-1 익명객체  hi sally ★
		//System.out.println(d1.hi(1, "sally")); // hi sally ★
		//System.out.println(d1.hi(2, "sally")); // hi sally ★★
		InterD2 d1 = new InterD2() {
			@Override public String hi(int num, String name) { // 별의 갯수 , 이름
				String star ="";
				for(int i=0;i<num;i++) { star += "★"; }
				return "hi " + name + star; }
			}; 
		System.out.println( d1.hi(1, "sally") ); 
		System.out.println( d1.hi(2, "sally") );
		//4-2 lambda ()->{  }
		InterD2 d2 = ( num, name ) -> { 
			String star ="";
			for(int i=0;i<num;i++) { star += "★"; }
			return "hi " + name + star; 
			};	
		System.out.println( d2.hi(3, "alpha") ); 
		System.out.println( d2.hi(4, "alpha") );
		
		InterD2 d3 = (num,name) -> { return "hi " + name + "★".repeat(num); };
		System.out.println( d3.hi(5, "alpha") ); 
		
		InterD2 d4 = (num,name) -> "hi " + name + "★".repeat(num);
		System.out.println( d4.hi(6, "alpha") ); 
		
		
	}
}
