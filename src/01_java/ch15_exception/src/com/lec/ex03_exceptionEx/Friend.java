package com.lec.ex03_exceptionEx;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	
	@Override // ȫ�浿 - ***-****-9999
	public String toString() {
		// TODO Auto-generated method stub
		String post = tel.substring(tel.lastIndexOf("-") + 1);
		return name + "=  *** - **** - " + post;
	}
}
