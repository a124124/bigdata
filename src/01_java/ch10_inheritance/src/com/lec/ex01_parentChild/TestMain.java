package com.lec.ex01_parentChild;

public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		System.out.println(child.cStr);
		System.out.println(child.pStr);
		child.getPapaName();
		child.getMamaName();
	}
}
