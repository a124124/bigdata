package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);		
		pObj1.method1();
		pObj1.method2();
		pObj2.method1();
		pObj2.method2();
		System.out.println("----------------------------");
		
		ChildClass cObj1 = new ChildClass();
		 
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
	
		System.out.println("----------------------------");
		
		ParentClass cObj2 = new ChildClass(4);
		cObj2.method1();
		cObj2.method2();
		//cObj2.method3(); 타입 때문에 실행이 안됨.
		((ChildClass)cObj2).method3();
	}
	
}
