package com.lec.ex06_car;

public class HighGradeCar extends Car{
	private int tax = 150000; //�⺻ ���� 
	public HighGradeCar(String color, String tire, int displacement) {
		super(color, tire, displacement);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getSpec() {
		// TODO Auto-generated method stub
		System.out.println("���� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		if(getDisplacement() > 1600) {
			tax += (getDisplacement() - 2200) * 100;
		}
		
		System.out.println("��  �� : " + tax);
		System.out.println("---------------------------");
	}

}