package com.lec.ex06_car;

public class HighGradeCar extends Car{
	private int tax = 150000; //기본 세금 
	public HighGradeCar(String color, String tire, int displacement) {
		super(color, tire, displacement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getSpec() {
		// TODO Auto-generated method stub
		System.out.println("색상 : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement());
		if(getDisplacement() > 1600) {
			tax += (getDisplacement() - 2200) * 100;
		}
		
		System.out.println("세  금 : " + tax);
		System.out.println("---------------------------");
	}

}
