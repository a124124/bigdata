package com.lec.ex02;
// Super method1(�߻� �޼ҵ�), method2(�Ϲ� �޼ҵ�)
// Child method1(�Ϲ� �޼ҵ�), method2(�Ϲ� �޼ҵ�), method3(�Ϲ� �޼ҵ�) 
public class Child extends Super{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Child�� method1() - �߻�޼ҵ�� �ݵ�� Override �ؾ���.");
	}
	public void method3() {
		System.out.println("Child �� method3()");
	}

}