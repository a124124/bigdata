package com.lec.ex03_math;
 // 반올림, 올림, 버림
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		
		System.out.println("9.12 의 올림 : " + Math.ceil(9.12));
		System.out.println("9.12 의 반올림 : " + Math.round(9.12));
		System.out.println("9.12 의 내림 : " + Math.floor(9.12));
		System.out.println("------------------------------");
		System.out.println("소수점 1자리에서 반올림, 올림, 내림");
		System.out.println("9.15 의 소수점 1자리 올림 : " + Math.ceil(9.15*10)/10.0);
		System.out.println("9.15 의 소수점 1자리 반올림 : " + Math.round(9.15 * 10)/ 10.0);
		System.out.println("9.15 의 소수점 1자리 내림 :" + Math.floor(9.15 * 10) / 10.0);
		System.out.println("------------------------------");
		System.out.println("1의 자리에서 반올림, 올림, 버림");
		System.out.println("85 의 올림 :" + (int)Math.ceil(85 / 10.0) * 10);
		System.out.println("85의 반올림 : " + Math.round(85 / 10.0) * 10);
		System.out.println("85의 내림 : " + (int)Math.floor(85 / 10.0) * 10);
		
		
		
	}
}
