package com.lec.ex02_super;
// main �Լ����� Child child = new Child(1,2);
public class Child extends SuperIJ{
	private int total;
	public Child() {
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j) {
//		this.i = i;
//		this.j = j;
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ�");
	}
	public void sum() {
		total = getI() + getJ();  // total = i + j;
		System.out.println("�� ��ü�� total ���� " + total);
	}

}