package com.lec.ex03;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandChild g = new GrandChild();
		g.method1();
		g.method2();
		g.method3();
		System.out.println("-------------------------------------------------");
		Child c = new GrandChild();
		
		c.method1();
		c.method2();
		c.method3();
		System.out.println("-------------------------------------------------");
		Super s = new GrandChild();
		s.method1();
		s.method2();
		((Child)s).method3();
		System.out.println("-------------------------------------------------");
		
	}

}
