package com.lec.loop;

public class Ex06_continue {
	public static void main(String[] args) {
		for(int i = 1; i < 6; i++) {
			if(i == 3) {
				continue; // �ݺ��� ���� for(���� > ����)�κ����� 
			}
			System.out.println("i =" + i);
		}
	}
}
