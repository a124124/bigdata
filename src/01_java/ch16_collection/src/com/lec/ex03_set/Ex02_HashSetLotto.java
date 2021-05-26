package com.lec.ex03_set;

import java.util.Random;
import java.util.TreeSet;

public class Ex02_HashSetLotto {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		while(lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);
			
		}
		System.out.println(lotto);
		
	}
}
