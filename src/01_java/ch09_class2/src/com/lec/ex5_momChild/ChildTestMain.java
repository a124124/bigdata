package com.lec.ex5_momChild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child("ù��");
		Child child2 = new Child("��°");
		Child child3 = new Child("��°");
		
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println("ù° ���� ���� : " + Child.momPouch.money);
		System.out.println("��° ���� ���� : " + child2.momPouch.money);
		System.out.println("��° ���� ���� : " + child3.momPouch.money);
		
	}
}
