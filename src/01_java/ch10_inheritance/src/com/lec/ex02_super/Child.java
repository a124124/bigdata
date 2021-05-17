package com.lec.ex02_super;
// main 함수에서 Child child = new Child(1,2);
public class Child extends SuperIJ{
	private int total;
	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) {
//		this.i = i;
//		this.j = j;
		setI(i);
		setJ(j);
		System.out.println("매개변수 있는 Child 생성자 함수");
	}
	public void sum() {
		total = getI() + getJ();  // total = i + j;
		System.out.println("본 객체의 total 값은 " + total);
	}

}
