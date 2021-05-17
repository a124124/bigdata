package com.lec.ex01_parentChild;

public class ChildClass extends ParentClass {
	String cStr = "자식클래스 = ChildClass";
	public ChildClass() {
		System.out.println("자식 클래스 객체 부분 생성시 호출");
	}
}
