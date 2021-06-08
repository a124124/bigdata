package com.lec.ex01_string;

public class Ex09_speedcheck {
	public static void main(String[] args) {
		

		String str = "A";
		//���۽ð� ����
		//str 10���� �ٲٱ�
		//������ �ð� ����
		long start = System.currentTimeMillis();
		
		
		System.out.println(start);
		for(int i = 0; i < 100000; i ++) {
			str = str.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("String 10���� ������ �ð� " + (end - start));
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
		System.out.println("StringBuffer 10���� ������ �ð� " + (end - start));
		
		System.out.println("-------------------------");
		StringBuilder strBuilder = new StringBuilder("A");
		start = System.currentTimeMillis();
		System.out.println(start);
		
		for(int i = 0; i < 1000000; i ++) {
			strBuilder.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("StringBuilder 10���� ������ �ð� " + (end - start));
		
	
	
	}
}