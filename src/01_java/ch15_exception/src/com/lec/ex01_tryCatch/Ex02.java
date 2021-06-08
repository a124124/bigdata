package com.lec.ex01_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		int j;
		do {
			System.out.println("ù��° �� �Է� ");
			try {
				
				i = sc.nextInt();
				break;
				
			}catch(InputMismatchException e) {
				System.out.println("ù��° ���ڸ� �ٽ� �Է��ϼ���");
				sc.nextLine(); // ���۸� ����� ����
			}
		}while(true);
		
		System.out.println("�ι�° �� �Է� ");
		do {
			try {
				j = sc.nextInt();
				
				System.out.println("i = " + i + "\tj = " + j);
				
				System.out.println("i + j = " + (i + j));
				System.out.println("i - j = " + (i - j));
				System.out.println("i * j = " + (i * j));
				
				System.out.println("i / j = " + (i / j));  // ���ܰ� �߻� �Ҽ��� �ְ�, ���Ҽ��� �ִ� �κп� ����ó���� �Ѵ�.
				break;
			}catch(ArithmeticException e) {
				System.out.println("���� ���� ���ڸ� �Է����ּ���.");
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("�ι�° ���ڸ� �ٽ� �Է��ϼ���");  //���� �޼��� ���.
				sc.nextLine();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(true);
		System.out.println("��");
		
		sc.close();
	}
}