package com.lec.ex01_string;

import java.util.Scanner;

// �ֹι�ȣ�� �Է¹޾� �������� �������� Ȯ��.
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		String i = scanner.next();
		System.out.println("�Է��Ͻ� �ֹι�ȣ : " + i);
		System.out.println((i.substring(7,8).equals("1") || i.substring(7, 8).equals("3") ? "����" : i.substring(7,8).equals("2") || i.substring(7, 8).equals("4") ? "����" : "����"));
	}
}
