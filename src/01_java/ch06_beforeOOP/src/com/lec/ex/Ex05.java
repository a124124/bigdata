package com.lec.ex;

import java.util.Scanner;

// �޼ҵ��� ���ȣ��   ! = ����ǥ�� ���丮�� �̶��θ�. 
// 3! = 3 * 2 * 1
// 2! = 2 * 1
// 1! = 1            ���ȣ�� ���� ��.
//
// n! = n * (n-1)   <n! = 1 ��
// 3! = 3 * (3-1) * (3-2) 
// 2! = 2 * (2-1)
// 1! = 1            ���ȣ�� �� ��.
// ���丮���� ������� ���.
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int su = 0;
		
		System.out.print("�� !�� ����ұ��? ");
		do {
			su = scanner.nextInt();
			if(su > 0) break;
			System.out.print("����� �Է��ϼ���");
		}while(true);
		long result = factorial(su);
		
		System.out.println(su + "! �� :" + result );
		scanner.close();
	}
	private static long factorial(int su) {
		if(su == 1) {
			return 1;
		}else {
			return su * factorial(su - 1);
			
		}
	}//main
	
//	private static long factorial(int su) {
//		long result = 1;
//		for(int i = su; i >=1; i--) {
//			 
//			result *= i;
//		}
//		return result;
//	}
//	
	
}//class
