package com.lec.ex;
//오늘의 문제1) 배열에 담긴 값을 더하는 프로그램을 작성
//int[] arr =  { 10, 20, 30, 40, 50}  


public class Quiz1 {
	public static void main(String[] args) {
		int[] arr =  { 10, 20, 30, 40, 50};
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
					
		}
		System.out.printf("합 : %d", total);
	}
}
