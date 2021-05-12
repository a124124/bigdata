package com.lec.loop;
//퀴즈 ② 1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Quiz02_for {
	public static void main(String[] args) {
		int su = 0;
		int su1 = 0;
		
		for (int i = 1; i <= 10; i ++) {
			if (i % 2 == 0) {
				su = su + i;
			}else {
				su1 = su1 + i;
			}
		}
		System.out.println("짝수 합:" + su);
		System.out.println("홀수 합:" + su1);
	}
}
