package com.lec.rect;

public class RectMain {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		Rect r2 = new Rect();
		
		System.out.printf("���� �� : %d %d\n", r1.getWidth(), r1.getHeight());
		System.out.printf("���� �� : %d %d\n", r2.getWidth(), r2.getHeight());
		// ���� ���� �����ϴ� setter�� �Է�.
		r1.setWidth(5);
		r1.setHeight(10);
		r2.setWidth(4);
		r2.setHeight(10);
		
		System.out.printf("���� �� : %d %d\n", r1.getWidth(), r1.getHeight());
		System.out.printf("���� �� : %d %d\n", r2.getWidth(), r2.getHeight());
		
		System.out.println("���� : " + r1.area());
		System.out.println("���� : " + r2.area());
				
		
		
	}
}