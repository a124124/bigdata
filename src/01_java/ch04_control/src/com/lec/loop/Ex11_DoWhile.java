package com.lec.loop;

import java.util.Scanner;

// ����ڷκ��� ¦���� �Է¹޾� ���.
public class Ex11_DoWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		do {
			System.out.println("¦�� �Է� :");
			num = scanner.nextInt();
		}while(num % 2 != 0);
		System.out.println("�Է��Ͻ� ¦���� :"+ num);
		scanner.close();
		
	}//main
}//class
