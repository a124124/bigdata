package com.lec.ex10_Test;

public class Person {
	private String id;
	private String name;
//	private String ban;
//	private String subject;
//	private String department;
//	
	
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void print() {
		System.out.println("(ID) " + id + "\t(?̸?) " + name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
