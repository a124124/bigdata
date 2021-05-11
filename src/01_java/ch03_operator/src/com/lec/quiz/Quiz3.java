package com.lec.quiz;

import java.util.Scanner;

//(연습문제3) 두수를 입력받아 
//두 수가 같은지 결과를 O나 X로 출력.
//첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수 입력 :");
		int numFirst = scanner.nextInt();
		System.out.print("두번째 수 입력 :");
		int numSecond = scanner.nextInt();
		String result = (numFirst >= numSecond) ? "O" : "X";
		System.out.println(result);
		scanner.close();
		
	}
}
