package com.lect.ex5_square;

public class BoxOrRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(5, 10);
		box.calV();
		rect.calV();
		System.out.println(box.getVolume());
		
	}
}
