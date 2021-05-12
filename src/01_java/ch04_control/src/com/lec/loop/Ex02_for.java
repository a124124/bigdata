package com.lec.loop;
// 1부터 20까지 누적 합을 출력
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0;
		for (int i=1; i<=20; i++) {
			tot += i;
			if (i<20) {
				System.out.print(i+"+");	
			}else {
				System.out.print(i);
			}
			
		}
		System.out.println("="+tot);
	}
}
