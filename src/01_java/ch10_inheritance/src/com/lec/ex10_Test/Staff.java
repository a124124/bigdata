package com.lec.ex10_Test;

public class Staff extends Person{
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	@Override
	public void print() {
		System.out.println("(ID) " + getId() + "\t(�̸�) " + getName() + "\t (�μ�) " + department);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
