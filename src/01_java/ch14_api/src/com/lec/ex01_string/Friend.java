package com.lec.ex01_string;

public class Friend {
	private String name;
	private String phone;
	private String birthDay;

	public Friend(String name, String phone, String birthDay) {
		super();
		this.name = name;
		this.phone = phone;
		this.birthDay = birthDay;
	}
	

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirthDay() {
		return birthDay;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("�� �� : %s\n�ڵ��� : %s\n�� �� : %s\n", name, phone, birthDay);
	}



	

}
