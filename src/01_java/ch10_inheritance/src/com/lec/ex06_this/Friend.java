package com.lec.ex06_this;
// this() = �� Ŭ������ ������ �Լ�
// this. = �� ��ü��
public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this(); //Friend() ȣ��
		this.name = name;
				System.out.println("�Ű����� �ϳ� ¥�� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name); //Friend(name) ȣ��
		this.name = name;
		this.tel = tel;
		System.out.println("�Ű����� �ΰ� ¥��  ������ �Լ� �ʱ�ȭ");
		
	}
	
}
