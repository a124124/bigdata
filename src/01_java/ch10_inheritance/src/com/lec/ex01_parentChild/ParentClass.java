package com.lec.ex01_parentChild;

public class ParentClass {
	String pStr = "부모클래스 = SuperClass";
	public ParentClass() {
		System.out.println("부모클래스 객체 부분 생성할 때 호출되는 생성자 함수");
	}
	public void getPapaName() {
		System.out.println("아빠 이름 : 홍길동");
		
	}
	public void getMamaName() {
		System.out.println("엄마 이름 : 김길순");
		
	}
}
