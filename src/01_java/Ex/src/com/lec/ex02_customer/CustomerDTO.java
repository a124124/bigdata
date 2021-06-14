package com.lec.ex02_customer;

public class CustomerDTO {
	private int id;
	private String name;
	private String phone;
	private int point;

	public CustomerDTO(int id, String name, String phone, int point) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.point = point;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +"님 포인트는 " + point +" 점 입니다.";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

}
