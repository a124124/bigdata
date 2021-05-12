package com.lec.loop;
// 1~100까지의 숫자 중 3의 배수들의 누적 합을 구하라.
public class Ex10_while {
	public static void main(String[] args) {
		int tot = 0;
		int i = 0;
		while(++i <= 100) {
			if(i % 3 != 0) {
				continue;
			}
			tot += i;
		}
		System.out.println("3의 배수들의 누적 합"+ tot);
	}
}
