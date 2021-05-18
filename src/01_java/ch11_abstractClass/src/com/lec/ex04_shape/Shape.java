package com.lec.ex04_shape;
// Circle, Triangle, Rectangle
public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");
	}
	public abstract double computeArea();
}
