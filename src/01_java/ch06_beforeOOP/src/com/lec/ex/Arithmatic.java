package com.lec.ex;
//함수의 오버로딩 :sum(1,10)
//sum(10,100)
public class Arithmatic {
	public int sum(int from, int to) {
		int result = 0; //숫자를 합쳐서 결과값을 내놓는다. sum 은 매개변수가 2개있어야한다. (*, *)
		for(int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) {
		int result = 0;
		for(int i = 0; i < to; i++) {
			result += i;
		}
		return result;
	}
	
	public String evenOdd(int value) {
		return value % 2 == 0 ? "짝수" : "홀수";
	}
	public int abs(int value) {
		int result = value >= 0 ? value : -value;
		return result;
	}
}
