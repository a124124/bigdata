package com.lec.ex04_object;

public class TestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(5, 10, 15);
		Point3D p3 = (Point3D) p2.clone();
//		p2.setX(20);

		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		System.out.println("p3 = " + p3);

		if (p2 == p3) {
			System.out.println("???? ??ü");
		} else {
			System.out.println("?ٸ? ??ü");
		}
		if (p2.equals(p3)) {
			System.out.println("???? ??ǥ");
		} else {
			System.out.println("?ٸ? ??ǥ");
		}
		
	}
}
