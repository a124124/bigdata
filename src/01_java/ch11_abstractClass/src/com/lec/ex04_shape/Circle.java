package com.lec.ex04_shape;

public class Circle extends Shape{
	
	private int r;
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("���� �׷���");
	}
	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
//		System.out.println("���� ���̴� " + (3.14 * r * r));
		return 3.14 * r * r;
		
	}
	

}