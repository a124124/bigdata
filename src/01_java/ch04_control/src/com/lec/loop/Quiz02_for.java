package com.lec.loop;
//���� �� 1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���
public class Quiz02_for {
	public static void main(String[] args) {
		int su = 0;
		int su1 = 0;
		
		for (int i = 1; i <= 10; i ++) {
			if (i % 2 == 0) {
				su = su + i;
			}else {
				su1 = su1 + i;
			}
		}
		System.out.println("¦�� ��:" + su);
		System.out.println("Ȧ�� ��:" + su1);
	}
}
