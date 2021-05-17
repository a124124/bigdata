package com.lec.ex02_super;

public class TestMain {
	public static void main(String[] args) {
		Child child = new Child(1,2);
		System.out.println("i 값 : " + child.getI());
		System.out.println("j 값 : " + child.getJ());
		child.sum();
		child.setI(100);
		child.setJ(200);
		System.out.println("i 값 : " + child.getI());
		System.out.println("j 값 : " + child.getJ());
		child.sum();
	}
}
