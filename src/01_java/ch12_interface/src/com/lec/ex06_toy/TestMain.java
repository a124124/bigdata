package com.lec.ex06_toy;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = {new Pooh(),
					  new Mazinger(),
					  new Airplane() 
		};
		
		for(IToy i : toy) {
		//t ��ü�� Ŭ���� �̸�
		System.out.println(i.getClass().getName());
		// t.toString() �ڵ� ȣ��
		System.out.println(i);
		}
	}
}
