package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex10_tokenizing {
	public static void main(String[] args) {
		String str = "가 나 다 라 마 바 사 아 자 차 카 타 파 하 가 갸 거 겨 고 교 구 규 그 기";
		String str1 = "가.나.다.라.마.바.사.아.자.차.카.타.파.하.가.갸.거.겨.고.교.구.규.그.기";
		StringTokenizer token1 = new StringTokenizer(str); // str 을 space구분자로 분할하여
		StringTokenizer token2 = new StringTokenizer(str1, "."); // str을 .구분자로 분할하여.
		System.out.println(str);
		System.out.println(token1);
		System.out.println(str1);
		System.out.println(token2);
		System.out.println("token1 의 데이터 개수 : " + token1.countTokens());
		System.out.println("token2의 데이터 개수 : " + token2.countTokens());

		while (token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		System.out.println("token1 의 데이터 개수 : " + token1.countTokens());
		
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextElement());
		}

		System.out.println("token2의 데이터 개수 : " + token2.countTokens());

	}
}
