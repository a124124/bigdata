package com.lec.ex5_momChild;
// Child first = new Child("ù°");
// first.takeMoney(1000); 
// first.momPouch.money �� 2õ��
public class Child {
	private String name; 
	MomPouch momPouch = new MomPouch();
	
	public Child(String name) {
		this.name = name;
	}

	public Child() {
		// TODO Auto-generated constructor stub
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
//			momPouch.money = momPouch.money - money;
			momPouch.money -= money;
			System.out.println(name + "��" + money + "�� �������� �������� " + momPouch.money + "�� ����");
		}else {
			System.out.println(name + "�� ���� ������. �������� " + momPouch.money +"��");
		}
	}
	
}
