package com.lec.ex03_math;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(Math.random() * 45);
		System.out.println("2의 3승은 : " + (int)Math.pow(2, 13));
		System.out.println("-9.9의 절대값은 : " + Math.abs(-9.9));
		System.out.println("16의 제곱근은 : " + Math.sqrt(16));
		System.out.println("1, 2의 최소값은 : " + Math.min(1, 2));
		System.out.println("1, 2의 최대값은 : " + Math.max(1, 2));
		// Math 의 변수(static 은 변수)
		System.out.println("pi 값은 : " + Math.PI);
	}
}
