package com.lec.quiz;

import java.util.Scanner;

//(��������2) �Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է� :");
		int num = scanner.nextInt();
		String result = (num % 2 == 0) ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		System.out.println("�Է��Ͻ� ���� : " +num);
		System.out.println("�Է��Ͻ� ���� : " +result);
		scanner.close();
		
	}
}
