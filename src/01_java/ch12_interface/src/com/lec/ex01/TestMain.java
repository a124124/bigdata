package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceClass obj = new InterfaceClass();
		System.out.println(obj.CONSTANT_NUM);
		System.out.println(obj.CONSTANT_STRING);
		System.out.println(InterfaceClass.CONSTANT_NUM);
		System.out.println(InterfaceClass.CONSTANT_STRING);
		System.out.println(InterfaceEx01.CONSTANT_NUM);
		System.out.println(InterfaceEx02.CONSTANT_STRING);
		obj.method1();
		obj.method2();
		System.out.println("-------------------------------------");
		InterfaceEx01 obj1 = new InterfaceClass();
		((InterfaceClass)obj1).method2();
		InterfaceEx02 obj2 = new InterfaceClass();
		obj2.method2();
		
	}

}
