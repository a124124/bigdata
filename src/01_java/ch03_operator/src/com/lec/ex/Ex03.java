package com.lec.ex;
// 동등비교연산자(관계연산자) : >, >=, <=, ==, !=
public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10; 
		int n2 = 5;
		boolean result;
		result = n1 >= n2; //여러개 있을경우 우선순위를 잘 봐야한다.우선순위가 애매할 경우 () 를 사용한다.
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		result = n1 == n2; //여러개 있을경우 우선순위를 잘 봐야한다.우선순위가 애매할 경우 () 를 사용한다.
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		result = n1 != n2;
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
		result = !(n1 != n2); // !는 논리연산자(반대를 의미)
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
	}
}
