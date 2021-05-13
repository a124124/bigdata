package com.lec.ex;

import java.util.Scanner;

// 메소드의 재귀호출   ! = 느낌표를 팩토리얼 이라고부름. 
// 3! = 3 * 2 * 1
// 2! = 2 * 1
// 1! = 1            재귀호출 쓰기 전.
//
// n! = n * (n-1)   <n! = 1 일
// 3! = 3 * (3-1) * (3-2) 
// 2! = 2 * (2-1)
// 1! = 1            재귀호출 쓴 후.
// 팩토리얼은 양수값만 계산.
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int su = 0;
		
		System.out.print("몇 !을 계산할까요? ");
		do {
			su = scanner.nextInt();
			if(su > 0) break;
			System.out.print("양수를 입력하세요");
		}while(true);
		long result = factorial(su);
		
		System.out.println(su + "! 값 :" + result );
		scanner.close();
	}
	private static long factorial(int su) {
		if(su == 1) {
			return 1;
		}else {
			return su * factorial(su - 1);
			
		}
	}//main
	
//	private static long factorial(int su) {
//		long result = 1;
//		for(int i = su; i >=1; i--) {
//			 
//			result *= i;
//		}
//		return result;
//	}
//	
	
}//class
