package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_HashSetStudent {
	public static void main(String[] args) {
		HashSet<Student> student = new HashSet<Student>();
		Student s = new Student(6, "이순신");
		student.add(s);
		student.add(s);
		
		
		System.out.println(student);
		
		
		student.add(new Student(3, "홍길동"));
		student.add(new Student(5, "김길동"));
		student.add(new Student(1, "나길동"));
		student.add(new Student(1, "나길동"));
		System.out.println(student);
	}
}
