package com.lec.ex01;
// InterfaceEx01 : CONSTANT_NUM, method1()
// InterfaceEx02 : CONSTANT_STRING , method2()
public class InterfaceClass implements InterfaceEx01, InterfaceEx02{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("1. 실제 구현은 implements 한 클래스에서 한다.");
		
	}
	@Override
	public String method2() {
		// TODO Auto-generated method stub
		System.out.println("2. 실제 구현은 implements 한 클래스에서 한다.");
		return null;
	}


}
