// ��Ű���� , Ŭ������ , ������ , �������Լ� , �޼ҵ� , setter , getter �� �Ϻ��� Ŭ������ ���
package com.lect.ex1_square;  //��Ű����

public class Square {      //Ŭ������
	
	private int side;     // ������
	
	
	public Square() {      //������ �Լ� : return Ÿ���� ����. �ݵ�� Ŭ���� ���̶� ���ƾ��Ѵ�.
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���"); // main(); Square s = Square()   
	}
	public Square(int side) {  //������ �Լ� (�Ű����� ����)   main(); Square s = Square(10)  
		this.side = side;
		System.out.println("�Ű������� �ִ� ������ �Լ� ȣ���. side �ʱ�ȭ �Ϸ�");  // �뵵 : ������ �ʱ�ȭ
	}
	public int area() {      // �޼ҵ�
		return side * side;
		
	}
	public void setSide(int side) {		//setter Square square = new Square(); square.setSide(10); s.
		this.side = side;
	}
	public int getSide() {			//getter , square.getSide();
		return side;
	}
}
