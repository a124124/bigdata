package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주소를 입력하세요");
		String address = sc.nextLine(); // 버퍼에 \n 이 나오기전까지 값을 취한다.
		System.out.println("입력하신 주소는 : " + address);
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt(); //
		System.out.println("입력하신 나이는 " + age);
		System.out.println("이름을 입력하세요");
		String name = sc.next(); // 버퍼에 처음 나오는 \n는 무시하고 whiteSpace 나오기 전까지의 값을 취함.
		System.out.println("입력하신 이름은 : " + name);
		sc.nextLine(); // 버퍼를 지우기 위해 nextLine 을 한번더 입력해준다. nextLine이 맨 처음일경우 필요없다.
		
	}
}
