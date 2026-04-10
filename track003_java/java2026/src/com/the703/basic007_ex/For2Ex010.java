package com.the703.basic007_ex;

public class For2Ex010 {

	public static void main(String[] args) {
		
		//ver1
		System.out.print('A'); System.out.print('B'); System.out.print('C'); System.out.print('D'); System.out.println(); 
		System.out.print('A'); System.out.print('B'); System.out.print('C'); System.out.println(); 
		System.out.print('A'); System.out.print('B'); System.out.println(); 
		System.out.print('A'); System.out.println();
		
		//ver2
		for(char ch='A';ch<='Z';ch++){ System.out.print(ch); } System.out.println();
		for(char ch='A';ch<='Y';ch++){ System.out.print(ch); } System.out.println();
		for(char ch='A';ch<='X';ch++){ System.out.print(ch); } System.out.println();
		
		//ver3
		System.out.println("ver-for");
		for(char a='Z';a>='A';a--) { for(char ch='A';ch<=a;ch++){ System.out.print(ch); } System.out.println(); }
		
		System.out.println("\nver-while");
		char a='Z';
		while(a>='A') {
			char ch='A';
			while(ch<=a) { System.out.print(ch); ch++; } System.out.println();
		a--;}
		
		System.out.println("\nver-do while");
		a='Z';
		do {
		char ch='A';
		do { System.out.print(ch); ch++; } while(ch<=a); 
		System.out.println(); a--;
		} while(a>='A');
		
	}

}
/*
이중 for ,while ,do while

ABCDEFGHIJKLMNOPQRSTUVWXYZ
...
ABCD
ABC
AB
A
*/