package com.lec.ex01_string;

public class Ex07_string {
	public static void main(String[] args) {
		String str = "Hello~";
		String str1 = "Hello~";

		System.out.println(str.hashCode());
		System.out.println(str == str1 ? "���� �ּ�" : "�ٸ� �ּ�");

		str = "Hello"; // str �� ������ ����Ǹ� �ٽ� String ��ü ����.
		System.out.println(str.hashCode());
		str = "hello";
		System.out.println(str.hashCode());
		System.out.println(str == str1 ? "���� �ּ�" : "�ٸ� �ּ�");

		System.out.println(str1.hashCode());
		str = "Hello~";
		
		System.out.println(str == str1 ? "���� �ּ�" : "�ٸ� �ּ�");
		
	}
}