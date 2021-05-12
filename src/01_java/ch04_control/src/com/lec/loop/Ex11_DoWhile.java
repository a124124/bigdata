package com.lec.loop;

import java.util.Scanner;

// 사용자로부터 짝수를 입력받아 출력.
public class Ex11_DoWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		do {
			System.out.println("짝수 입력 :");
			num = scanner.nextInt();
		}while(num % 2 != 0);
		System.out.println("입력하신 짝수는 :"+ num);
		scanner.close();
		
	}//main
}//class
