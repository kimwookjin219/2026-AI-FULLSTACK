package com.the703.basic007_ex;

public class For2Ex009 {
	public static void main(String[] args) {
		
		//ver1
		System.out.print('A'); System.out.println();
		System.out.print('A'); System.out.print('B'); System.out.println();
		
		//ver2
		for(char ch='A';ch<='A';ch++) { System.out.print(ch); } System.out.println();
		for(char ch='A';ch<='B';ch++) { System.out.print(ch); } System.out.println();
		for(char ch='A';ch<='C';ch++) { System.out.print(ch); } System.out.println();
		for(char ch='A';ch<='D';ch++) { System.out.print(ch); } System.out.println();
		
		for(char a='A'; a<='Z'; a++  ){ 
			for(char ch='A';ch<=a;ch++) { System.out.print(ch); } System.out.println(); 
			}
		
		char a='A';
		while(a<='Z') { 
			char ch='A';
			while(ch<=a) { System.out.print(ch); ch++; } System.out.println(); a++;
		}
		a='A';
		do {
		char ch='A';
		do { System.out.print(ch); ch++; } 
		while(ch<=a);  
		System.out.println(); a++; }
		while( a<='Z' );
	}
}
/*
이중 for ,while ,do while

A
AB
ABC
ABCD
...
ABCDEFGHIJKLMNOPQRSTUVWXYZ
*/