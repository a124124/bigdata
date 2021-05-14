package com.lect.ex5_square;

public class BoxOrRect {
	private int width;  //����
	private int depth;  //����
	private int height;  //����
	private int volume; //���ǳ� ����
	
	

	public BoxOrRect() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public BoxOrRect(int width, int depth) {
		super();
		this.width = width;
		this.depth = depth;
	}

	public BoxOrRect(int width, int depth, int volume) {
		this.width = width;
		this.depth = depth;
		this.volume = volume;
	}


	public void calV() {
		if(height != 0) {
			volume = width * depth * height; //������ü
		}else {
			volume = width * depth;
		}
	
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
