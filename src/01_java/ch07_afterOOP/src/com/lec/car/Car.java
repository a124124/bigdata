package com.lec.car;
// ������(private), �޼ҵ�(public) private �� �＼���Ҽ��ִµ� setter �� getter �� �����.
public class Car {
	private String color; //�Ӽ� , ������ ��� �θ�.
	private String brand;
	private int cc; 
	private int speed;

	public void parking() {
		speed = 0;
		System.out.println("�����Ѵ�. �ӵ� :" + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println("������. �ӵ� :" + speed);
	}
	public void race() {
		speed = 120;
		System.out.println("���̽�. �ӵ� :" + speed);
	}
	// setter �� getter�� ���� �޼ҵ� �ؿ� �����.(����)
	//setter
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
