package com.lec.ex1_grade;

public class Grade {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average; 
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public Grade(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
//	public void infoTotal1() {
//		System.out.printf("%s \t %d \t %d \t %d \t %d \t %.1f", name, kor, eng, math, total, average);
//	}
		
	public String infoTotal() {
		total = kor + eng + math;
		average = total / 3.0;
		String result;
		result = String.format("%s \t %d \t %d \t %d \t %d \t %.1f", name, kor, eng, math, total, average);
//				name + "   " + kor + "   " + eng + "   " + math + "   " + total + "   " + average;
		return result;
	}
	// getter 추가 (총점 누적 시 필요함)
}
