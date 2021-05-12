package com.lec.loop;

import java.util.Scanner;

//퀴즈 ③ 사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력해 보자
public class Quiz03_for {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째숫자 입력:");
		int su = scanner.nextInt();
		System.out.println("두번째숫자 입력:");
		int su1 = scanner.nextInt();
		System.out.printf("%d와 %d의 곱은 ?", su, su1);
		int su2 = su * su1;
		System.out.println(su2);
	}
}
