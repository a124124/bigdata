package com.lec.ex08_person;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person papa = new Person("�ƺ���", "�׶���");
		Person mama = new Person("������", "������");
		papa.intro();
		mama.intro();
		System.out.println("----------------------------------------------");
		Baby child1 = new Baby();
		System.out.println(child1.getName());
		child1.setName("�Ʊ��1");
		child1.setCharacter("�Ϳ���");
		child1.cry();
		child1.intro();
		System.out.println("----------------------------------------------");
		Baby child2 = new Baby("�Ʊ��2", "���Ϳ���");
		child2.intro();
		
		
	}
	

}
