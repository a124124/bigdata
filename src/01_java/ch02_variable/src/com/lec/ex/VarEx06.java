package com.lec.ex;

// 형변환은 묵시적인 형변환과 명시적인 형변환이 있다.
public class VarEx06 {
	public static void main(String[] args) {
		int i1=10;
		double d1= i1; // 묵시적인 형변환, i1 변우의 값을 d1에 할당(작은 주머니 데이터를 큰 주머니에 넣을 때)
		System.out.printf("i1=%d, d1=%f\n", i1, d1);
		i1 = (int)d1; // 명시적인 형변환(큰 주머니 데이터를 작은 주머니에 할당)
		System.out.printf("i1=%d, d1=%.2f\n", i1, d1);
	}
	

}
