package com.lec.ex03_math;

import java.util.Random;

// 배열에 로또번호 6개 저장하기.
public class Ex04_lotto {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] lotto = new int[6];
		for(int i = 0; i < 6; i++) {
			boolean ok = true;
			int temp = (int)(Math.random() * 45) + 1;
//			lotto[i] = random.nextInt(45) + 1;
			for(int j = 0; j < i ; j++) {
				if(temp == lotto[j]) {
					i--;
					ok = false;
					break;
				}
			} // 발생된 난수의 중복확인 용도.
			if(ok == true) {
				lotto[i] = temp;
			}
		}
		for(int l : lotto) {
			System.out.println(l + "\t");
		}
	
		
	}
}
