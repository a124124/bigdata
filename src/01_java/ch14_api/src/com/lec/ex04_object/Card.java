package com.lec.ex04_object;

public class Card {
	private char kind; //카드 종류 (♡♥ ♧♣ ♤♠ ◇◆)
	private int num; // a : 1  2~10, j 11 q 12 k 13
	
	public Card(char kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "카드는  " + kind + " " + num;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// c1.equals(c2) = c1 c2 가 같은 카드면 true, 다른 카드면 false를 return 하도록 만들어보자.
		if(obj != null && obj instanceof Card) {
			boolean kindChk = kind == ((Card)obj).kind; 
			boolean numChk = num == ((Card)obj).num;
			return kindChk && numChk;
			
		}else {
			return false;
		}
		
		
	}
}
