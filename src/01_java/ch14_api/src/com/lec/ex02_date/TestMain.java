package com.lec.ex02_date;

public class TestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "홍길동", Part.COMPUTER);
		Sawon s2 = new Sawon("a02", "이길동", Part.ACCOUNTING);
		Sawon s3 = new Sawon("a03", "삼길동", Part.HUMANRESOURCES, 2021, 10, 5);
		Sawon s4 = new Sawon("a04", "사길동", Part.DESIGN);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

}
