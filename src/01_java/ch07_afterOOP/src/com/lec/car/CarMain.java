package com.lec.car;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("빨강");
		System.out.println(myPorsche.getColor());
		myPorsche.drive();
		myPorsche.race();
		myPorsche.parking();
		Car yourPorsche = new Car();
		yourPorsche.setColor("Gray");
		System.out.println("내차 색상 : " + myPorsche.getColor());
		System.out.println("니차 색상 : " + yourPorsche.getColor());
		
	}
}
