package com.lec.ex03_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random() * 45) + 1); // Math.random() 은 static 형식이다.
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt());
		System.out.println("0 부터 44까지의 int 난수 :" + random.nextInt(45));
		System.out.println("double 난수 : " + random.nextDouble());
		
	}
}
