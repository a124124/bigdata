package com.lec.ex06_car;

public class CarMain {
	public static void main(String[] args) {
		Car highcar = new HighGradeCar("����", "�Ϲ� Ÿ�̾�", 3000);
		Car lowcar = new LowGradeCar("���", "�Ϲ� Ÿ�̾�", 1000);
		highcar.getSpec();
		lowcar.getSpec();
	}
}
