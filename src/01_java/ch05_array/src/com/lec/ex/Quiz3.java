package com.lec.ex;
/* 
 * 
 *  오늘의 문제3) 76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 
	결과값 :  
		합    계 = 576  평    균 = 72 
		최대값은 = 100  최소값은 = 34
*/


public class Quiz3 {
	public static void main(String[] args) {
		int[] score = {76, 45, 34, 89, 100, 50, 90, 92};
		int total = 0;
				for(int i = 0; i < score.length; i++) {
			total += score[i];
			
		}
		System.out.printf("합계 : %d 평균 : %d\n", total, total/score.length);
		
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
		System.out.println("최소값 :" + minI +" " + "최대값 :" + maxI);
				
	}
}
