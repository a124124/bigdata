package com.lec.ex10_Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person[] person = {new Student("A01", "���л�", "JAVA��"),
						   new Student("A02", "ȫ�浿", "C++��"),
						   new Staff("S01", "������", "������"),
						   new Staff("S02", "������", "���������"),
						   new Gangsa("G01", "������", "���α׷���")
		};
		
		for(Person i : person) {
			i.print();
		}

	}
}