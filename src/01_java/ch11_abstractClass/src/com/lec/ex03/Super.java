package com.lec.ex03;
// Super s; 가능
// new Super(); 불가능
//Super method1(추상), method2(일반)

public abstract class Super {
	public Super() { // 디폴트 생성자
	
	}
	public abstract void method1(); //추상 메소드 , 상속 받는 클래스에서 반드시 Override 해야함.
	public void method2() {
		System.out.println("Super의 method2()");
	}
	
}
