package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹޾� Ȧ/¦ ���θ� ���.
public class Ex06_switch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������?");
		int score = scanner.nextInt();
		int temp = (score == 100) ? score - 1 : score; //100��
		temp = (temp >= -9 && temp <= -1) ? temp - 10 : temp;
		switch (score/10) {
		case 10 :
		case 9 : System.out.println("A");break;
		case 8 : System.out.println("B");break;
		case 7 : System.out.println("C");break;
		case 6 : System.out.println("D");break;
		case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
			System.out.println("F");break;
		default :
			System.out.println("��ȿ���� ���� ����");
		}
		
//		if(score>=90 && score<=100) {
//			System.out.println("A");
//		}else if(80<=score && score<90) {
//			System.out.println("B");
//		}else if(70<=score && score<80) {
//			System.out.println("C");
//		}else if(60<=score && score<70) {
//			System.out.println("D");
//		}else if(0<=score && score<60) {
//			System.out.println("F");
//		}

		
	}	
	
}
