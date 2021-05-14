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
		System.out.printf("이름 : %s, 나이 : %d, 성별 : %c\n", name, age, gender);
	}
	public String infoString() {
		String result = "이름 : " + name +", 나이 : " + age + ", 성별 : " + gender;
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
		// Person 객체 변수 2개 생성하고 출력
		Person[] person = {new Person("홍길동", 20, 'M'),
						   new Person("홍길순", 22, 'F'),
						   new Person()
		};
		person[2].setName("이지"); 
		person[2].setAge(40);
		person[2].setGender('F');
		for(int idx = 0; idx < person.length; idx++) {  //일반 for문
			System.out.println(person[idx].infoString());
		}
		for(Person p : person) { // 확장 for문
			System.out.println(p.infoString());
		}
	}
}
