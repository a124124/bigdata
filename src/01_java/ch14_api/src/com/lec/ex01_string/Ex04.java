package com.lec.ex01_string;
//문자열 뒤집기, 짝수번재 문자열만 출력.
public class Ex04 {
	public static void main(String[] args) {
		String str = "2002 WorldCup Korea";
		System.out.println(str);
		for(int i = 0; i < str.length(); i++) {
			if(i % 2 == 0) {
				System.out.print(" ");
			}else {
				System.out.print(str.charAt(i));
			}
	
		}
		System.out.println();
		System.out.println(str);
		System.out.println(str.equalsIgnoreCase("y"));
	}
}
