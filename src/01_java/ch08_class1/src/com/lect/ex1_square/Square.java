// 패키지명 , 클래스명 , 데이터 , 생성자함수 , 메소드 , setter , getter 가 완벽한 클래스의 모습
package com.lect.ex1_square;  //패키지명

public class Square {      //클래스명
	
	private int side;     // 데이터
	
	
	public Square() {      //생성자 함수 : return 타입이 없다. 반드시 클래스 명이랑 같아야한다.
		System.out.println("매개변수 없는 생성자 함수 호출됨"); // main(); Square s = Square()   
	}
	public Square(int side) {  //생성자 함수 (매개변수 있음)   main(); Square s = Square(10)  
		this.side = side;
		System.out.println("매개변수가 있는 생성자 함수 호출됨. side 초기화 완료");  // 용도 : 데이터 초기화
	}
	public int area() {      // 메소드
		return side * side;
		
	}
	public void setSide(int side) {		//setter Square square = new Square(); square.setSide(10); s.
		this.side = side;
	}
	public int getSide() {			//getter , square.getSide();
		return side;
	}
}
