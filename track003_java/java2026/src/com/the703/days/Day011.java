package com.the703.days;

import java.util.Scanner;

public class Day011 {
	public static void main(String[] args) {
		char a ='\u0000';
	    Scanner sc = new Scanner(System.in);

	    System.out.print("a,b,c 중 하나 입력>");  a=sc.next().charAt(0);
	    
	    if(a=='a') { System.out.println("apple"); }
	    else if(a=='b') { System.out.println("banana"); }
	    else if(a=='c') { System.out.println("coconut"); }
	    
	    switch(a) {
	    case 'a': System.out.println("apple"); break;
	    case 'b': System.out.println("banana"); break;
	    case 'c': System.out.println("coconut"); break;
	    }
	    
	    for(int i=1; i<=5; i++) { System.out.print(i+"\t"); }
	    
	    System.out.println();
	    
	    int i=1;
	    while(i<=5) { System.out.print(i+"\t"); i++; }
	    
	    System.out.println();
	    
	    i=1;
	    do { System.out.print(i+"\t"); i++; }
	    while(i<=5);
	    
	}
}
/*
1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
    char a ='\u0000';
    Scanner sc = new Scanner(System.in);

    System.out.print("a,b,c 중 하나 입력>");  a=sc.next().charAt(0);
    
2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
     1  2  3  4  5
    
*/