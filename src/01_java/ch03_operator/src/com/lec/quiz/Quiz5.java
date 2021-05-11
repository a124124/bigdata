package com.lec.quiz;

import java.util.Scanner;

//(연습문제5) 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 
//평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수 입력 :");
		int korea = scanner.nextInt();
		System.out.print("영어점수 입력 :");
		int english = scanner.nextInt();
		System.out.print("수학점수 입력 :");
		int math = scanner.nextInt();
		
		System.out.println("국어점수 : " + korea);
		System.out.println("영어점수 : " + english);
		System.out.println("수학점수 : " + math);
		
		int score = korea + english + math;
		System.out.println("총점 : " + score);
		
		int average = score / 3;
		System.out.println("평균 : " + average);
		scanner.close();
			
	}
}
