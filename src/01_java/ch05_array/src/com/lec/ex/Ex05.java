package com.lec.ex;

import java.util.Scanner;

// 영희 철수 길동 영수 말자 키 입력 받아 평균을 구하고, (큰학생과 작은학생의 이름과 키를 표시)
public class Ex05 {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};
		int[] arrHeight = new int[arrName.length];
		Scanner scanner = new Scanner(System.in);
		int total = 0;
		for(int idx = 0; idx < arrName.length; idx++) {
			System.out.print(arrName[idx] + "의 키는?");
			arrHeight[idx] = scanner.nextInt();
			total += arrHeight[idx];
				
		}
		System.out.printf("평균키 : %.2f\n", (double)total/arrHeight.length);
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
		System.out.printf("가장 큰 학생은 : %s, 키 : %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("가장 작은 학생은 : %s, 키 : %d\n", arrName[minIdx], minHeight);
		
		
		
		
	}
}
