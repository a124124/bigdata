package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ּҸ� �Է��ϼ���");
		String address = sc.nextLine(); // ���ۿ� \n �� ������������ ���� ���Ѵ�.
		System.out.println("�Է��Ͻ� �ּҴ� : " + address);
		System.out.println("���̸� �Է��ϼ���");
		int age = sc.nextInt(); //
		System.out.println("�Է��Ͻ� ���̴� " + age);
		System.out.println("�̸��� �Է��ϼ���");
		String name = sc.next(); // ���ۿ� ó�� ������ \n�� �����ϰ� whiteSpace ������ �������� ���� ����.
		System.out.println("�Է��Ͻ� �̸��� : " + name);
		sc.nextLine(); // ���۸� ����� ���� nextLine �� �ѹ��� �Է����ش�. nextLine�� �� ó���ϰ�� �ʿ����.
		
	}
}