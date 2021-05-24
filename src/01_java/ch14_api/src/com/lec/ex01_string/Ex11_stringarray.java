package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_stringarray {
	public static void main(String[] args) {
		String str = "가 나 다 라 마 바 사 아 자 차 카 타 파 하 가 갸 거 겨 고 교 구 규 그 기";
		
		StringTokenizer token = new StringTokenizer(str);
		String[] arr = new String[token.countTokens()];
		int idx = 0;
		while(token.hasMoreTokens()) {
			arr[idx++] = token.nextToken();
		}
		System.out.println("배열에 제대로 들어갔는지 확인");
		
		for(String a : arr) {
			System.out.println(a);
			
		}
	}
	
	
}
