package com.lec.ex;
// ���� ������ : ++ -- 
public class Ex02 {
	public static void main(String[] args) {
		int numFirst = 10;
//		int num_first = 10;  python ��Ÿ��
		int n = ++numFirst;
		
		System.out.println(numFirst);
		
		System.out.printf("n = %d, numFirst = %d\n", n, numFirst);
		n = --numFirst;
		System.out.printf("n = %d, numFirst = %d\n", n, numFirst);
		
	}
}
