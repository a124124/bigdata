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
		
		int[] iArr2 = new int[5]; // 2. 배열 변수 선언과 배열 메모리 공간 확보 (배열 객체 생성)
		iArr2[0] = 99;
		for(int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(idx + "번째 값 :" + iArr2[idx]);
			
		}
			int[] iArr3;  //3. 배열 변수만 선언
			iArr3 = new int[3]; // 0 0 0 0 0 0
			
//			for(int temp : iArr3) {// 확장 for문을 이용한 배열 값 변경 불가.
//				temp = 999;
//			}
//			
			for(int idx = 0; idx < iArr3.length; idx++ ) {
				iArr3[idx] = 999;
			}
			for (int temp : iArr3)  { //확장 for문을 이용한 배열 접근
				System.out.println(temp);
			}
			
//			for(int idx = 0; idx < iArr3.length; idx++) {
//			System.out.println(iArr3[idx]);
//			}
			
		
		
		}
		
	}

