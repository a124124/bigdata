package com.lec.ex01_string;

import java.util.Scanner;

// 주민번호를 입력받아 남자인지 여자인지 확인.
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요");
		String i = scanner.next();
		System.out.println("입력하신 주민번호 : " + i);
		System.out.println((i.substring(7,8).equals("1") || i.substring(7, 8).equals("3") ? "남자" : i.substring(7,8).equals("2") || i.substring(7, 8).equals("4") ? "여자" : "오류"));
	}
}
