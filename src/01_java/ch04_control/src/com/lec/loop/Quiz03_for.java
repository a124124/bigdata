package com.lec.loop;

import java.util.Scanner;

//���� �� ����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ����� ����
public class Quiz03_for {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ù��°���� �Է�:");
		int su = scanner.nextInt();
		System.out.println("�ι�°���� �Է�:");
		int su1 = scanner.nextInt();
		System.out.printf("%d�� %d�� ���� ?", su, su1);
		int su2 = su * su1;
		System.out.println(su2);
	}
}
