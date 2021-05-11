package com.lec.quiz;

import java.util.Scanner;

//(연습문제2) 입력한 수가 짝수인지 홀수인지 출력
public class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 입력 :");
		int num = scanner.nextInt();
		String result = (num % 2 == 0) ? "짝수입니다" : "홀수입니다";
		System.out.println("입력하신 수는 : " +num);
		System.out.println("입력하신 수는 : " +result);
		scanner.close();
		
	}
}
