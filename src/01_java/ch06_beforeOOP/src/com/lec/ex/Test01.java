package com.lec.ex;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numFirst = 0;
		
		
		System.out.println("구구단 몇단을 계산할까요?");
		do {
			numFirst = scanner.nextInt();
			if(numFirst > 1 && numFirst < 10) break;
			System.out.println("2~9 사이의 수를 입력하세요");
			
		}while(true);
		
		 mul(numFirst);
		 scanner.close();
		
	}
	private static void mul(int su) {
		for(int i = 1; i < 10; i++) {
			System.out.println(su + "*" + i + "=" + su * i);
		}
		
	}
}
