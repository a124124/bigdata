package com.lec.loop;
// 1���� 20���� ���� �߿��� 2�� 3�� ����� �ƴ� ���� ��	
public class Homework1 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i<21; i++ ) {
			if(i % 2 != 0 && i % 3 != 0) {
				System.out.println(" 1���� 20������ ���� �߿��� 2�� 3�� ����� �ƴ� ���� ��" + sum);
				sum = sum + i;	
			}
			
		}
		System.out.println("��� : " + sum);
	}
}
