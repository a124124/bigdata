package com.lec.car;
// 데이터(private), 메소드(public) private 를 억세스할수있는데 setter 와 getter 를 만든다.
public class Car {
	private String color; //속성 , 데이터 라고 부름.
//	private String brand;
	private int cc; 
	private int speed;

	public void parking() {
		speed = 0;
		System.out.println("주차한다. 속도 :" + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println("운전중. 속도 :" + speed);
	}
	public void race() {
		speed = 120;
		System.out.println("레이싱. 속도 :" + speed);
	}
	// setter 와 getter는 목적 메소드 밑에 만든다.(보통)
	//setter
	public void setColor(String color) {
		this.color = color;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//getter (리턴을 받아야한다)
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
}
