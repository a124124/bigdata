package com.lec.ex01;
// InterfaceEx01 : CONSTANT_NUM, method1()
// InterfaceEx02 : CONSTANT_STRING , method2()
public class InterfaceClass implements InterfaceEx01, InterfaceEx02{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("1. ���� ������ implements �� Ŭ�������� �Ѵ�.");
		
	}
	@Override
	public String method2() {
		// TODO Auto-generated method stub
		System.out.println("2. ���� ������ implements �� Ŭ�������� �Ѵ�.");
		return null;
	}


}