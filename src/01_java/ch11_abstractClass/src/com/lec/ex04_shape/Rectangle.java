package com.lec.ex04_shape;

public class Rectangle extends Shape{
	private int w;
	private int h;
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
//		System.out.println("사각형의 넓이는 " + w * h);
		return w * h;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그려요");
	}
	
}
