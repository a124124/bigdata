package com.lec.ex;
/* 
 * 
 *  ������ ����3) 76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�. 
	����� :  
		��    �� = 576  ��    �� = 72 
		�ִ밪�� = 100  �ּҰ��� = 34
*/


public class Quiz3 {
	public static void main(String[] args) {
		int[] score = {76, 45, 34, 89, 100, 50, 90, 92};
		int total = 0;
				for(int i = 0; i < score.length; i++) {
			total += score[i];
			
		}
		System.out.printf("�հ� : %d ��� : %d\n", total, total/score.length);
		
		int minI = 999;
		for(int i = 0; i < score.length; i++) {
			if(score[i] <= minI) {
				minI = score[i];
			}
		}
		
		int maxI = 0;
		for(int i = 0; i < score.length; i++) {
			if(score[i] >= maxI) {
				maxI = score[i];
			}
		}
		System.out.println("�ּҰ� :" + minI +" " + "�ִ밪 :" + maxI);
				
	}
}