package com.lec.quiz;

import java.util.Scanner;

// 사용자에게 숫자를 입력받아 그게 3의 배수인지 아닌지 출력하라 
public class Quiz1 {
	public static void main(String[] args) {
//		int i = 10;
//		String name = "설현"
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 입력 :");
		int su = scanner.nextInt(); // 키보드로부터 입력받은 정수를 반환하는 함수 
		String result = (su % 3 == 0) ? "3의배수입니다." : "3의 배수가 아닙니다.";
		System.out.println("입력하신 수는 "+ su);
		System.out.println("입력하신 수는 " + result);
		scanner.close();
				
	}
}
