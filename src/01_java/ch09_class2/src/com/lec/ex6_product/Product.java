package com.lec.ex6_product;

public class Product {
	private int serialNo; //��ü ���� ��ȣ.
	private String name;
	public static int count = 100;
	
	public Product(String name) {
		this.name = name;
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.printf("��ǰ�� : %s , �ø����ȣ : %d , �������� count : %d\n", name, serialNo, count);
	}
}