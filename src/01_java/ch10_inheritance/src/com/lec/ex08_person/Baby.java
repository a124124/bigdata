package com.lec.ex08_person;

public class Baby extends Person{
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		super(name, character); //�θ���� ������ ȣ��, �Ű����� �ִ� �θ���� ������ super()�� �׻� ù ���ɾ�� ȣ���Ͽ�����.
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	public void cry() {
		System.out.println("���� ���� ");
	}
	@Override
	public void intro() {
		System.out.println(getName() + "��(��) �Ʊ�� ������ ��� �Ұ��ҰԿ�.");
		super.intro();
	}
	
}