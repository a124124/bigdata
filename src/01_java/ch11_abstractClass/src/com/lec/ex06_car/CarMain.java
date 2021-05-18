package com.lec.ex06_car;

public class CarMain {
	public static void main(String[] args) {
		Car highcar = new HighGradeCar("빨강", "일반 타이어", 3000);
		Car lowcar = new LowGradeCar("흰색", "일반 타이어", 1000);
		highcar.getSpec();
		lowcar.getSpec();
	}
}
