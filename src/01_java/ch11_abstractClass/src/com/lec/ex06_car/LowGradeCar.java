package com.lec.ex06_car;

public class LowGradeCar extends Car{
	private int tax = 50000; //�⺻ ���� 
	public LowGradeCar(String color, String tire, int displacement) {
		super(color, tire, displacement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getSpec() {
		// TODO Auto-generated method stub
		System.out.println("���� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		if(getDisplacement() > 1000) {
			tax += (getDisplacement() - 1000) * 80;
		}
		
		System.out.println("��  �� : " + tax);
		System.out.println("---------------------------");
	}

}