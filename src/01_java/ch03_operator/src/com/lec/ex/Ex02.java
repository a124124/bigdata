package com.lec.ex;
// 증강 연산자 : ++ -- 
public class Ex02 {
	public static void main(String[] args) {
		int numFirst = 10;
//		int num_first = 10;  python 스타일
		int n = ++numFirst;
		
		System.out.println(numFirst);
		
		System.out.printf("n = %d, numFirst = %d\n", n, numFirst);
		n = --numFirst;
		System.out.printf("n = %d, numFirst = %d\n", n, numFirst);
		
	}
}
