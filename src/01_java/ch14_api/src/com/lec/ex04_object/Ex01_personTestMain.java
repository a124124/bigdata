package com.lec.ex04_object;

public class Ex01_personTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(2105251000001L);
		Person p2 = new Person(2105251000001L);
		Person p3 = null;

		if (p1.equals(p2)) {
			System.out.println("p1�� p2 �� ���� ��ü");
		} else {
			System.out.println("p1�� p2 �� �ٸ� ��ü");
		}
		if (p1.equals(p3)) {
			System.out.println("p1�� p2 �� ���� ��ü");
		} else {
			System.out.println("p1�� p2 �� �ٸ� ��ü");
		}

		if (p1 == p2) {
			System.out.println("p1�� p2 �� ���� �ּ�");
		} else {
			System.out.println("p1�� p2 �� �ٸ� �ּ�");
		}

	}

}
