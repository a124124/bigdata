package com.lec.ex;

public class VarEx05 {
	public static void main(String[] args) {
//		float f = 10.0000017F;
		float f = (float)10.0007;  //명시적인 형변환
		System.out.println("f ="+f);
		double d = 10.0007;
		System.out.println("d ="+d);
		if (f == d) {
			System.out.println("두 변수는 같다");
		}
	}
}
