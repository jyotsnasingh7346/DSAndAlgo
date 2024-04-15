package com.dsandalgo.interviewPrep;

public class AccolitePrintWithoutLoops {

					// Solution 1: 
//	public static void main(String[] args) {
//		
//		int n = 10;
//		printNumbers(n);
//
//	}
//
//	private static void printNumbers(int n) {
//		
//		if (n > 0) {
//			printNumbers(n-1);
//			System.out.println(n);
//		}
//		
//	}
					// Solution 2:
	static int i = 1;
	static int n = 10;
	public static void main(String[] args) {
		if (i <= n) {
			System.out.printf("%d", i++);
			main(null);
		}
		
	}
}
