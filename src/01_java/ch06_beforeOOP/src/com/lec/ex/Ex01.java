package com.lec.ex;
// ���� �������� ���α׷��� 1~10 ���� ������ ���� ���ϰ� ¦/Ȧ ����
public class Ex01 {
	public static void main(String[] args) {
		int total = 0;
		for(int i = 0; i < 11; i++) {
			total += i;
		}
		System.out.println(total);
		System.out.println((total % 2 == 0) ? "¦��" : "Ȧ��");
		
		total = 0;
		for(int i = 10; i < 101; i++) {
			total += i;
		}
		System.out.println(total);
		System.out.println((total % 2 == 0) ? "¦��" : "Ȧ��");	
	}
	

}