package com.lec.condition;

import java.util.Scanner;
//(�ǽ�����3) ����ڷκ��� ����, ����, ���� ������ �Է¹޾� �� ���� ������ ��� �̻����� �������� ����� ����
public class Ex04_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������� �Է� :");
		int korea = scanner.nextInt();
		System.out.print("�������� �Է� :");
		int english = scanner.nextInt();
		System.out.print("�������� �Է� :");
		int math = scanner.nextInt();
		
		int sum = korea + english + math;
		double ave = sum / 3;
		
		System.out.println();
	}
}
