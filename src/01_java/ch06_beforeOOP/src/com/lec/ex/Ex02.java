package com.lec.ex;
// �޼ҵ�
public class Ex02 {
	public static void main(String[] args) {
		int total = 0;
		total = sum(1,10);
		System.out.println(evenOdd(total));
		
		total = sum(1,10);
		System.out.println(evenOdd(total));
	}

	private static int sum(int from, int to) {
		// TODO Auto-generated method stub
			int result = 0;
			for(int i = from; i <=to; i++) {
				result += i;
			}
		return result;
	}
}
