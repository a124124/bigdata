package com.lec.ex3_accessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
//		obj.protectedMember();
		obj.protectedMethod();
//		obj.privateMethod();
		obj.defaultMethod();
		obj.publicMethod();
		
		
	}
}
