package com.lec.ex03_math;
 // �ݿø�, �ø�, ����
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		
		System.out.println("9.12 �� �ø� : " + Math.ceil(9.12));
		System.out.println("9.12 �� �ݿø� : " + Math.round(9.12));
		System.out.println("9.12 �� ���� : " + Math.floor(9.12));
		System.out.println("------------------------------");
		System.out.println("�Ҽ��� 1�ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.15 �� �Ҽ��� 1�ڸ� �ø� : " + Math.ceil(9.15*10)/10.0);
		System.out.println("9.15 �� �Ҽ��� 1�ڸ� �ݿø� : " + Math.round(9.15 * 10)/ 10.0);
		System.out.println("9.15 �� �Ҽ��� 1�ڸ� ���� :" + Math.floor(9.15 * 10) / 10.0);
		System.out.println("------------------------------");
		System.out.println("1�� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85 �� �ø� :" + (int)Math.ceil(85 / 10.0) * 10);
		System.out.println("85�� �ݿø� : " + Math.round(85 / 10.0) * 10);
		System.out.println("85�� ���� : " + (int)Math.floor(85 / 10.0) * 10);
		
		
		
	}
}