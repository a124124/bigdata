package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {

		int i = 10;
		String str = "java";
		String str1 = "java";
		String str2 = "java";
		String str3 = "java";
		String str4 = new String("java");

		System.out.println(str1 == str2 ? "str1 str2 �� ���� �ּ�" : "str1 str2 �� �ٸ� �ּ�");
		System.out.println(str == str4 ? "str str4 �� ���� �ּ� " : "str str4 �� �ٸ� �ּ�");

		str1 = "Oracle";

		System.out.println(str1 == str2 ? "str1 str2 �� ���� �ּ�" : "str1 str2 �� �ٸ� �ּ�");
		if (str.equals(str4)) {
			System.out.println("���� ��Ʈ��");
		}
		System.out.println(str1.equals(str2) ? "���� ��Ʈ��" : "�ٸ� ��Ʈ��");
	}
}