package com.lec.rect;

public class RectMain {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		Rect r2 = new Rect();
		
		System.out.printf("설정 전 : %d %d\n", r1.getWidth(), r1.getHeight());
		System.out.printf("설정 전 : %d %d\n", r2.getWidth(), r2.getHeight());
		// 가로 세로 세팅하는 setter를 입력.
		r1.setWidth(5);
		r1.setHeight(10);
		r2.setWidth(4);
		r2.setHeight(10);
		
		System.out.printf("설정 후 : %d %d\n", r1.getWidth(), r1.getHeight());
		System.out.printf("설정 후 : %d %d\n", r2.getWidth(), r2.getHeight());
		
		System.out.println("넓이 : " + r1.area());
		System.out.println("넓이 : " + r2.area());
				
		
		
	}
}
