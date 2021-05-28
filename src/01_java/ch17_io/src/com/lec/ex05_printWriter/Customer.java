package com.lec.ex05_printWriter;

public class Customer {
	private String name;
	private String tel;
	private String birth;
	private String address;
	
	public Customer(String name, String tel, String birth, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\t" + tel + "\t" + birth + "\t" + address;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
