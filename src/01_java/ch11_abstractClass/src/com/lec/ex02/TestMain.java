package com.lec.ex02;
//Super method1(추상 메소드), method2(일반 메소드)
//Child method1(일반 메소드), method2(일반 메소드), method3(일반 메소드) 
public class TestMain {
	public static void main(String[] args) {
	//	 Super s = new Super(); // 추상 클래스는 객체를 생성할 수 없다.
		Child c1 = new Child();
		Super c2 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		c2.method1();
		c2.method2();
		((Child)c2).method3();
	}
}
