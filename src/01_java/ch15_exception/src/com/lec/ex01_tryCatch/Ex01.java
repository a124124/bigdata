package com.lec.ex01_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		int j;
		System.out.println("첫번째 수 입력 ");
		i = sc.nextInt();
		System.out.println("두번째 수 입력 ");
		j = sc.nextInt();
		System.out.println("i = " + i + "\tj = " + j);
		
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));  // 예외가 발생 할수도 있고, 안할수도 있는 부분에 예외처리를 한다.
		}catch(Exception e) {
			System.out.println(e.getMessage());  //예외 메세지 출력.
		}
		System.out.println("끝");
		
		sc.close();
	}
}
