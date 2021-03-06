package com.lec.ex;
// 비트연산자 &(AND), |(OR), ^(XOR)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10; // 2진수로 들어감, 0 1 0 1 0
		int n2 = 6;  // 0 1 0 1
		int result;  //-----------
		
		result = n1 & n2; //
		System.out.println("n1 & n2 = " + result);
		
		result = n1 | n2; //  0 1 1 1 0
		System.out.printf("n1 | n2 = %x (%d)\n", result, result);
		
		result = n1 ^ n2; // 0 1 1 0 0 (OR과는 다르다)
		System.out.printf("n1 ^ n2 = %x (%d)", result, result);
	}
}
