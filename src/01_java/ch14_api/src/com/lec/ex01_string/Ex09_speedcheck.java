package com.lec.ex01_string;

public class Ex09_speedcheck {
	public static void main(String[] args) {
		

		String str = "A";
		//시작시간 측정
		//str 10만번 바꾸기
		//끝나는 시간 측정
		long start = System.currentTimeMillis();
		
		
		System.out.println(start);
		for(int i = 0; i < 100000; i ++) {
			str = str.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("String 10만번 변경한 시간 " + (end - start));
		System.out.println("-------------------------");
		
		
		
		
		
		//
		StringBuffer strBuff = new StringBuffer("A");
		start = System.currentTimeMillis();
		System.out.println(start);
		
		for(int i = 0; i < 1000000; i ++) {
			strBuff.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("StringBuffer 10만번 변경한 시간 " + (end - start));
		
		System.out.println("-------------------------");
		StringBuilder strBuilder = new StringBuilder("A");
		start = System.currentTimeMillis();
		System.out.println(start);
		
		for(int i = 0; i < 1000000; i ++) {
			strBuilder.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("StringBuilder 10만번 변경한 시간 " + (end - start));
		
	
	
	}
}
