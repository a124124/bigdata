package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // 변수의 선언과 초기화.
		int[] iArr = {10, 20, 30, 40, 50}; // 1. 배열 변수 선언과 초기화
		iArr[0] = 90; //배열은 index 로 접근 (index : 0 ~ 4)  int[] iArr = {10, 20, 30, 40, 50}; 지금 설정한게 0~4까지밖에 없기 때문에.
		
		for(int idx = 0; idx < iArr.length; idx++) { //iArr.length 배열의 크기.
			System.out.println(iArr[idx]);
			
		}
//		System.out.println(iArr[0]);
//		System.out.println(iArr[1]);
//		System.out.println(iArr[2]);
	}
}
