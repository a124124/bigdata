package com.lect.ex1_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		Square s2 = new Square(6);
		System.out.println("s1의 한 변의 길이는 : " + s1.getSide());
		s1.setSide(5);
		System.out.println(s1.getSide());
		System.out.println(s1.area());
		System.out.println(s2.getSide());
		System.out.println(s2.area());
	}
}
