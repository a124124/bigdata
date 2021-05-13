package com.lec.ex;

import java.util.Scanner;

/*
 * 4. 오늘의 문제 : 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오.
	(단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9사이의 수를 입력할 때까지 계속 입력 받는다.)

 */
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numFirst = 0;
		int numSecond = 0;
		int result = 0;
		
		System.out.println("구구단 몇단을 계산할까요?");
		do {
			numFirst = scanner.nextInt();
			if(numFirst > 1 && numFirst < 10) break;
			System.out.println("2~9 사이의 수를 입력하세요");
			
		}while(true);
		
		System.out.println("곱할 수를 입력하세요");
		do {
			numSecond = scanner.nextInt();
			if(numSecond > 0 && numSecond < 10) break;
			System.out.println("1~9 사이의 수를 입력하세요");
			
		}while(true);
		
		result = mul(numFirst, numSecond);
		
		System.out.println(numFirst + "*" + numSecond + "=" + result);
		scanner.close();
		}

	
	private static int mul(int numFirst, int numSecond) {
		int result = 0;
		result = numFirst * numSecond;
		return result;
		
			
	}
}

	

