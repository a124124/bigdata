package com.lec.condition;
// ��ǻ�Ͱ� �߻��� ����(����)�� ���� ���(random)
public class Ex07_switch {
	public static void main(String[] args) {
//		System.out.println((int)(Math.random()*101));   // 0�̻� 1������ ������ �߻���Ų��.
		
		
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
