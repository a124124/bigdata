package com.lec.ex01_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		int j;
		do {
			System.out.println("첫번째 수 입력 ");
			try {
				
				i = sc.nextInt();
				break;
				
			}catch(InputMismatchException e) {
				System.out.println("첫번째 숫자를 다시 입력하세요");
				sc.nextLine(); // 버퍼를 지우는 목적
			}
		}while(true);
		
		System.out.println("두번째 수 입력 ");
		do {
			try {
				j = sc.nextInt();
				
				System.out.println("i = " + i + "\tj = " + j);
				
				System.out.println("i + j = " + (i + j));
				System.out.println("i - j = " + (i - j));
				System.out.println("i * j = " + (i * j));
				
				System.out.println("i / j = " + (i / j));  // 예외가 발생 할수도 있고, 안할수도 있는 부분에 예외처리를 한다.
				break;
			}catch(ArithmeticException e) {
				System.out.println("문자 말고 숫자를 입력해주세요.");
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("두번째 숫자를 다시 입력하세요");  //예외 메세지 출력.
				sc.nextLine();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(true);
		System.out.println("끝");
		
		sc.close();
	}
}
