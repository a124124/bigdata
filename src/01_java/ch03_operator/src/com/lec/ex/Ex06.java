package com.lec.ex;
// 할당연산자 (대입연산자) : =, +=, -=, *=, /=, %= 
public class Ex06 {
	public static void main(String[] args) {
		int n1 = 10 * 3;
		n1 += 10; // n1 = n1+10 한것과 똑같다.
		System.out.println("n1 = " + n1);
		int n2;
		int n3;
		n1 = n2 = n3 = 10;
		System.out.println(n1 + n2 + n3);
	}
}
