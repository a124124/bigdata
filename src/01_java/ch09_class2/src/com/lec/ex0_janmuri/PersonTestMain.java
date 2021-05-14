package com.lec.ex0_janmuri;

class Person{
	private String name;
	private int age;
	private char gender; // m or f
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}


	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void infoPrint() {
		System.out.printf("�̸� : %s, ���� : %d, ���� : %c\n", name, age, gender);
	}
	public String infoString() {
		String result = "�̸� : " + name +", ���� : " + age + ", ���� : " + gender;
		return result;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
}


public class PersonTestMain {
	public static void main(String[] args) {
		// Person ��ü ���� 2�� �����ϰ� ���
		Person[] person = {new Person("ȫ�浿", 20, 'M'),
						   new Person("ȫ���", 22, 'F'),
						   new Person()
		};
		person[2].setName("����"); 
		person[2].setAge(40);
		person[2].setGender('F');
		for(int idx = 0; idx < person.length; idx++) {  //�Ϲ� for��
			System.out.println(person[idx].infoString());
		}
		for(Person p : person) { // Ȯ�� for��
			System.out.println(p.infoString());
		}
	}
}
