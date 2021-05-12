package com.lec.condition;

import java.util.Scanner;

//(실습예제1) 수를 입력받아 절대값을 출력하는 프로그램
public class Ex03_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력 :");
		int num = scanner.nextInt();
		if (num>=0) {
			System.out.printf("입력한 수의 절대값 : %d\n", num);
		}else {
			System.out.printf("입력한 수의 절대값 : %d\n", -num);
		}
		scanner.close();
	}
}









//미완성
