package com.lec.loop;
// 퀴즈 ① 1~10까지의 곱을 구해보자
public class Quiz01_for {
	public static void main(String[] args) {
		long tot = 1;
		
		for(int i=1; i<11; i++) {
			tot *= i;
		}
		System.out.println("1~1000까지 누적 곱은 : " + tot);
	}
	
}
