package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S[] sArr = {new A(), new B(), new C()};
		S s = new S();
		A a = new A();
		S aa = new A();
		B b = new B();
		S bb = new B();
		C c = new C();
		S cc = new C();
		S[] arr = {a, b, c};
		System.out.println(c.toString());
		System.out.println(c);
	}
}
