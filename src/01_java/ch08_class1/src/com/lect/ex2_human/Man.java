package com.lect.ex2_human;

public class Man {
	private int age;
	
	public Man() {
		System.out.println("개발자가 생성자 함수를 만들지 않으면 컴파일러가 디폴트 생성자를 생섬함(Man)");
	}
	public Man(int age) {
		System.out.println("매개변수가 있는 Man 생성자 함수");
		this.age = age; // 데이터 초기화
	}
	
	
	
}
