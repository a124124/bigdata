package com.lec.ex;
//�Լ��� �����ε� :sum(1,10)
//sum(10,100)
public class Arithmatic {
	public int sum(int from, int to) {
		int result = 0; //���ڸ� ���ļ� ������� �����´�. sum �� �Ű������� 2���־���Ѵ�. (*, *)
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
		return value % 2 == 0 ? "¦��" : "Ȧ��";
	}
	public int abs(int value) {
		int result = value >= 0 ? value : -value;
		return result;
	}
}
