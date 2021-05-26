package com.lec.ex03_set;

public class Student {
	private int grade;
	private String name;
	public Student(int grade, String name) {
		super();
		this.grade = grade;
		this.name = name;
	}
	@Override
	public String toString() {
		return grade + "ÇÐ³â " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj != null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
			return toString().equals(obj.toString());
		}else {
			return false;
		}
	
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
}
