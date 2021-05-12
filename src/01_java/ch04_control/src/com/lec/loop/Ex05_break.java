package com.lec.loop;

public class Ex05_break {
	public static void main(String[] args) {
		for(int i = 1; i < 6; i++) {
			if(i == 3) break;
			System.out.println("i =" + i);
		}
	}
}
