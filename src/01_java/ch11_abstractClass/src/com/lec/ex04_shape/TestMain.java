package com.lec.ex04_shape;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] sp = {new Circle(6),
					  new Triangle(6,6),
					  new Rectangle(6,6)
		};
//		for(int i = 0; i < sp.length ; i++) {  // ���ܹ߻�(����ܰ迡���� ����)
//			sp[i].draw();
//			sp[i].computeArea();
//		}
		for(Shape n : sp) {
			n.draw();
			System.out.println("���̴� " + n.computeArea());
		}
	}

}