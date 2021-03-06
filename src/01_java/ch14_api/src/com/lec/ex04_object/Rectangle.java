package com.lec.ex04_object;

public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;
	
	
	public Rectangle() {
		color = "검정";
		// TODO Auto-generated constructor stub
	}


	public Rectangle(int width, int height, String color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("가로 %dcm 세로 %dcm의 %s색 네모", width, height, color);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj != null && obj instanceof Rectangle) {
			boolean wChk = width == ((Rectangle)obj).width;
			boolean hChk = height == ((Rectangle)obj).height;
			boolean cChk = color.equals(((Rectangle)obj).color);
			
			return wChk && hChk && cChk;
		}else {
			return false;
		}
		
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
}
