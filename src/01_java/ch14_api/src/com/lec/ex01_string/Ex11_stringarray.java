package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_stringarray {
	public static void main(String[] args) {
		String str = "�� �� �� �� �� �� �� �� �� �� ī Ÿ �� �� �� �� �� �� �� �� �� �� �� ��";
		
		StringTokenizer token = new StringTokenizer(str);
		String[] arr = new String[token.countTokens()];
		int idx = 0;
		while(token.hasMoreTokens()) {
			arr[idx++] = token.nextToken();
		}
		System.out.println("�迭�� ����� ������ Ȯ��");
		
		for(String a : arr) {
			System.out.println(a);
			
		}
	}
	
	
}
