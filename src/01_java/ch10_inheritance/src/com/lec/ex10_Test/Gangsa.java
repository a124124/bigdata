package com.lec.ex10_Test;

public class Gangsa extends Person{
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	@Override
	public void print() {
		System.out.println("(ID) " + getId() + "\t(�̸�)" + getName() + "\t (����) " + subject);
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	

}
