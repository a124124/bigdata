package com.lec.condition;

import java.util.Scanner;
//(실습예제3) 사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 이하인지 출력해 보자
public class Ex04_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수 입력 :");
		int korea = scanner.nextInt();
		System.out.print("영어점수 입력 :");
		int english = scanner.nextInt();
		System.out.print("수학점수 입력 :");
		int math = scanner.nextInt();
		
		int sum = korea + english + math;
		double ave = sum / 3;
		
		System.out.println();
	}
}
