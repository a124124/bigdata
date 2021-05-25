package com.lec.ex04_object;

import java.util.Random;

public class Ex02_cardTestMain {
	public static void main(String[] args) {
		Card[] card = {new Card('◇', 2),
					   new Card('♠', 3),
					   new Card('♡', 11),
					   new Card('♣', 7)
		};
		Random random = new Random();
		char[] kinds = {'♡', '♥', '♧', '♣', '♤', '♠', '◇', '◆'};
		Card com = new Card(kinds[random.nextInt(8)], random.nextInt(13)+1);
		System.out.println(com);
		for(int i = 0; i < card.length; i++ ) {
			if(card[i].equals(com)) {
				System.out.println(i + "번째 카드와 일치합니다 - " + card[i]);
			}else {
				System.out.println(i + "다릅니다 - " + card[i]);
			}
			
				
		}
		
	}
}
