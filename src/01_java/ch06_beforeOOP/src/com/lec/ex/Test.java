package com.lec.ex;

import java.util.Scanner;

/*
 * 4. ������ ���� : ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
	(��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. ����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)

 */
public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numFirst = 0;
		int numSecond = 0;
		int result = 0;
		
		System.out.println("������ ����� ����ұ��?");
		do {
			numFirst = scanner.nextInt();
			if(numFirst > 1 && numFirst < 10) break;
			System.out.println("2~9 ������ ���� �Է��ϼ���");
			
		}while(true);
		
		System.out.println("���� ���� �Է��ϼ���");
		do {
			numSecond = scanner.nextInt();
			if(numSecond > 0 && numSecond < 10) break;
			System.out.println("1~9 ������ ���� �Է��ϼ���");
			
		}while(true);
		
		result = mul(numFirst, numSecond);
		
		System.out.println(numFirst + "*" + numSecond + "=" + result);
		scanner.close();
		}

	
	private static int mul(int numFirst, int numSecond) {
		int result = 0;
		result = numFirst * numSecond;
		return result;
		
			
	}
}

	
