package com.lec.loop;
// ���� �� 1~10������ ���� ���غ���
public class Quiz01_for {
	public static void main(String[] args) {
		long tot = 1;
		
		for(int i=1; i<11; i++) {
			tot *= i;
		}
		System.out.println("1~1000���� ���� ���� : " + tot);
	}
	
}
