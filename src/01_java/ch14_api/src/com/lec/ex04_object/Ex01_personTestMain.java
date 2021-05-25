package com.lec.ex04_object;

public class Ex01_personTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(2105251000001L);
		Person p2 = new Person(2105251000001L);
		Person p3 = null;

		if (p1.equals(p2)) {
			System.out.println("p1과 p2 는 같은 객체");
		} else {
			System.out.println("p1과 p2 는 다른 객체");
		}
		if (p1.equals(p3)) {
			System.out.println("p1과 p2 는 같은 객체");
		} else {
			System.out.println("p1과 p2 는 다른 객체");
		}

		if (p1 == p2) {
			System.out.println("p1과 p2 는 같은 주소");
		} else {
			System.out.println("p1과 p2 는 다른 주소");
		}

	}

}
