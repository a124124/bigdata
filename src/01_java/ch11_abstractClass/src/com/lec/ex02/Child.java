package com.lec.ex02;
// Super method1(추상 메소드), method2(일반 메소드)
// Child method1(일반 메소드), method2(일반 메소드), method3(일반 메소드) 
public class Child extends Super{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Child의 method1() - 추상메소드라 반드시 Override 해야함.");
	}
	public void method3() {
		System.out.println("Child 의 method3()");
	}

}
