package com.lec.ex02;
//Super method1(�߻� �޼ҵ�), method2(�Ϲ� �޼ҵ�)
//Child method1(�Ϲ� �޼ҵ�), method2(�Ϲ� �޼ҵ�), method3(�Ϲ� �޼ҵ�) 
public class TestMain {
	public static void main(String[] args) {
	//	 Super s = new Super(); // �߻� Ŭ������ ��ü�� ������ �� ����.
		Child c1 = new Child();
		Super c2 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		c2.method1();
		c2.method2();
		((Child)c2).method3();
	}
}