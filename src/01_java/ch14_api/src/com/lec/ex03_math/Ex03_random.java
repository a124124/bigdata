package com.lec.ex03_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random() * 45) + 1); // Math.random() �� static �����̴�.
		Random random = new Random();
		System.out.println("int ���� : " + random.nextInt());
		System.out.println("0 ���� 44������ int ���� :" + random.nextInt(45));
		System.out.println("double ���� : " + random.nextDouble());
		
	}
}