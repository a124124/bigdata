package com.lec.ex01_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		int j;
		System.out.println("ù��° �� �Է� ");
		i = sc.nextInt();
		System.out.println("�ι�° �� �Է� ");
		j = sc.nextInt();
		System.out.println("i = " + i + "\tj = " + j);
		
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));  // ���ܰ� �߻� �Ҽ��� �ְ�, ���Ҽ��� �ִ� �κп� ����ó���� �Ѵ�.
		}catch(Exception e) {
			System.out.println(e.getMessage());  //���� �޼��� ���.
		}
		System.out.println("��");
		
		sc.close();
	}
}