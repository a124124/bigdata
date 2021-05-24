package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex10_tokenizing {
	public static void main(String[] args) {
		String str = "�� �� �� �� �� �� �� �� �� �� ī Ÿ �� �� �� �� �� �� �� �� �� �� �� ��";
		String str1 = "��.��.��.��.��.��.��.��.��.��.ī.Ÿ.��.��.��.��.��.��.��.��.��.��.��.��";
		StringTokenizer token1 = new StringTokenizer(str); // str �� space�����ڷ� �����Ͽ�
		StringTokenizer token2 = new StringTokenizer(str1, "."); // str�� .�����ڷ� �����Ͽ�.
		System.out.println(str);
		System.out.println(token1);
		System.out.println(str1);
		System.out.println(token2);
		System.out.println("token1 �� ������ ���� : " + token1.countTokens());
		System.out.println("token2�� ������ ���� : " + token2.countTokens());

		while (token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		System.out.println("token1 �� ������ ���� : " + token1.countTokens());
		
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextElement());
		}

		System.out.println("token2�� ������ ���� : " + token2.countTokens());

	}
}
