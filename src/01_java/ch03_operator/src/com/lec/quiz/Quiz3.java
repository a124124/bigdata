package com.lec.quiz;

import java.util.Scanner;

//(��������3) �μ��� �Է¹޾� 
//�� ���� ������ ����� O�� X�� ���.
//ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° �� �Է� :");
		int numFirst = scanner.nextInt();
		System.out.print("�ι�° �� �Է� :");
		int numSecond = scanner.nextInt();
		String result = (numFirst >= numSecond) ? "O" : "X";
		System.out.println(result);
		scanner.close();
		
	}
}
