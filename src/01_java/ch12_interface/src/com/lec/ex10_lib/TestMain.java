package com.lec.ex10_lib;

public class TestMain {
	public static void main(String[] args) {
		Book book1 = new Book("001", "�ڹ�", "�ڱ浿");
		Book book2 = new Book("002", "�ϵ�", "�ϱ浿");
		book1.checkIn();
		book1.checkOut("��浿", "210521");
		book1.checkOut("��浿", "210521");
		System.out.println(book1);
		System.out.println(book2);
	}
}
