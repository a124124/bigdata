package com.lec.ex8_student;

public class Student {
	
	private int studentNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average;
	public static int count = 0;
	public Student() {
		// TODO Auto-generated constructor stub
		
	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		studentNo = ++count;

	}
	public void infoToTal() {
		total = kor + eng + math;
		average = total / 3.0;
		System.out.printf("%d. \t %s \t %d \t %d \t %d \t %d \t %.1f\n", studentNo, name, kor, eng, math, total, average);
		
	}


	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public double getAverage() {
		return average;
	}

	
}
