package com.lec.ex06_toy;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = {new Pooh(),
					  new Mazinger(),
					  new Airplane() 
		};
		
		for(IToy i : toy) {
		//t 객체의 클래스 이름
		System.out.println(i.getClass().getName());
		// t.toString() 자동 호출
		System.out.println(i);
		}
	}
}
