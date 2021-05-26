package com.lec.ex01_list;

import java.util.Vector;

public class Ex03_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		AClass objA = new AClass();
		BClass objB = new BClass();
		
		vec.add(objA);
		vec.add(objB);
		vec.add("str");
		vec.add(10);
		
		System.out.println(vec);
		for(int i = 0; i < vec.size(); i++) {
			System.out.println(vec.get(i));
		}
	}
}
