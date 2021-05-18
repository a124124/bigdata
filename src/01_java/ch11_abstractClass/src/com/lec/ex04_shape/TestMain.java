package com.lec.ex04_shape;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] sp = {new Circle(6),
					  new Triangle(6,6),
					  new Rectangle(6,6)
		};
//		for(int i = 0; i < sp.length ; i++) {  // 예외발생(실행단계에서의 에러)
//			sp[i].draw();
//			sp[i].computeArea();
//		}
		for(Shape n : sp) {
			n.draw();
			System.out.println("넓이는 " + n.computeArea());
		}
	}

}
