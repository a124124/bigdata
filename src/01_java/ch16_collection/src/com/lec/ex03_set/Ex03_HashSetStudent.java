package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_HashSetStudent {
	public static void main(String[] args) {
		HashSet<Student> student = new HashSet<Student>();
		Student s = new Student(6, "�̼���");
		student.add(s);
		student.add(s);
		
		
		System.out.println(student);
		
		
		student.add(new Student(3, "ȫ�浿"));
		student.add(new Student(5, "��浿"));
		student.add(new Student(1, "���浿"));
		student.add(new Student(1, "���浿"));
		System.out.println(student);
	}
}