package com.lec.ex;

import java.util.Scanner;

// ���� ö�� �浿 ���� ���� Ű �Է� �޾� ����� ���ϰ�, (ū�л��� �����л��� �̸��� Ű�� ǥ��)
public class Ex05 {
	public static void main(String[] args) {
		String[] arrName = {"����", "ö��", "�浿", "����", "����"};
		int[] arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int total = 0;
		for(int idx = 0; idx < arrName.length; idx++) {
			System.out.print(arrName[idx] + "�� Ű��?");
			arrHeight[idx] = scanner.nextInt();
			total += arrHeight[idx];
				
		}
		System.out.printf("���Ű : %.2f\n", (double)total/arrHeight.length);
		scanner.close();
		int maxIdx = 0, maxHeight = 0;
		int minIdx = 0, minHeight = 999;
		
		for(int i = 0; i < arrHeight.length; i++) {
			if(arrHeight[i] >= maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
				
			}
			if(arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			}
		}
		System.out.printf("���� ū �л��� : %s, Ű : %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("���� ���� �л��� : %s, Ű : %d\n", arrName[minIdx], minHeight);
		
		
		
		
	}
}