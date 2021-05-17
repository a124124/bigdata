package com.lec.ex08_person;

public class Baby extends Person{
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); //부모단의 생성자 호출, 매개변수 있는 부모단의 생성자 super()는 항상 첫 명령어로 호출하여야함.
		System.out.println("매개변수 있는 Baby 생성자");
	}
	public void cry() {
		System.out.println("응애 응애 ");
	}
	@Override
	public void intro() {
		System.out.println(getName() + "은(는) 아기라서 엄마가 대신 소게할게요.");
		super.intro();
	}
	
}
