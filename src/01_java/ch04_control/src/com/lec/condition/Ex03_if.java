package com.lec.condition;

import java.util.Scanner;

//(�ǽ�����1) ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class Ex03_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է� :");
		int num = scanner.nextInt();
		if (num>=0) {
			System.out.printf("�Է��� ���� ���밪 : %d\n", num);
		}else {
			System.out.printf("�Է��� ���� ���밪 : %d\n", -num);
		}
		scanner.close();
	}
}









//�̿ϼ�
