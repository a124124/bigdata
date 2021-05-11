package com.lec.ex;
// 산술 연산자 : + - * / %
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result );
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result );
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %.2f\n", n1, '/', n2, resultDouble );
		result = n1 % n2; // n1 나누기 n2 의 나머지 
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result );
		//나머지 연산자의 용도 : 짝홀수 판별, 배수 판별
		if(n1 % 2 == 0) {
			System.out.println("n1은 짝수");
			
		}else {
			System.out.println("n1은 홀수");
		}
		if(n2 % 5 == 0) {
			System.out.println("n2는 5의배수");
		}else {
			System.out.println("n2는 5의 배수가 아니다");
		}
	}
}
