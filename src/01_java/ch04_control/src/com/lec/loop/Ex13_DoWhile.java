package com.lec.loop;

import java.util.Scanner;

// 로또 번호(1~45) 하나를 맞추는 프로그램.
public class Ex13_DoWhile {
	public static void main(String[] args) {
//		0 < Math.random() * 45 < 45
//		(int)(Math.random() * 45 ; 0~44 까지의 정수 난수
		int su, lotto;
		lotto = (int)(Math.random() * 45) + 1;
		Scanner scanner = new Scanner(System.in);
				
		do {
			System.out.print("1~45 사이의 숫자를 입력하세요");
			su = scanner.nextInt();
			if (su == lotto) {
				break;
			}
			else if(su < lotto) {
				System.out.println("업");
			}else if(su > lotto) {
				System.out.println("다운");
				
			}
		}while(true);
		System.out.println("정답");
		
	}
}
