package com.lec.ex01_string;

public class Ex07_string {
	public static void main(String[] args) {
		String str = "Hello~";
		String str1 = "Hello~";

		System.out.println(str.hashCode());
		System.out.println(str == str1 ? "같은 주소" : "다른 주소");

		str = "Hello"; // str 의 내용이 변경되면 다시 String 객체 생성.
		System.out.println(str.hashCode());
		str = "hello";
		System.out.println(str.hashCode());
		System.out.println(str == str1 ? "같은 주소" : "다른 주소");

		System.out.println(str1.hashCode());
		str = "Hello~";
		
		System.out.println(str == str1 ? "같은 주소" : "다른 주소");
		
	}
}
