package com.lec.condition;
// 컴퓨터가 발생한 점수(난수)의 학점 출력(random)
public class Ex07_switch {
	public static void main(String[] args) {
//		System.out.println((int)(Math.random()*101));   // 0이상 1이하의 난수를 발생시킨다.
		
		
		int score = (int)(Math.random()*101);
		switch (score / 10) {
		case 10 : case 9:
			System.out.println("A");break;
		case 8 : System.out.println("B");break;
		case 7 : System.out.println("C");break;
		case 6 : System.out.println("D");break;
		default :
			System.out.println("F");
		}
		System.out.println(score);
	}
}
