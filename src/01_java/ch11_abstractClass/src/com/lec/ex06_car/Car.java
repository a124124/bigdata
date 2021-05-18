package com.lec.ex06_car;

public abstract class Car {
	private String color;
	private String tire;
	private int displacement; //¹è±â·®
	
	public Car(String color, String tire, int displacement) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
	}
	
	public abstract void getSpec();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	
	
	
}
