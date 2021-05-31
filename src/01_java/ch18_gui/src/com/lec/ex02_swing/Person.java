package com.lec.ex02_swing;

public class Person {
	private String name;
	private String tel;
	private int age;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String name, String tel, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\t" + tel + "\t" + age;
	}
	
	

	
}
