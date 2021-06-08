package com.lec.ex04_object;

public class Card {
	private char kind; //ī�� ���� (���� ���� ���� �ޡ�)
	private int num; // a : 1  2~10, j 11 q 12 k 13
	
	public Card(char kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ī���  " + kind + " " + num;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// c1.equals(c2) = c1 c2 �� ���� ī��� true, �ٸ� ī��� false�� return �ϵ��� ������.
		if(obj != null && obj instanceof Card) {
			boolean kindChk = kind == ((Card)obj).kind; 
			boolean numChk = num == ((Card)obj).num;
			return kindChk && numChk;
			
		}else {
			return false;
		}
		
		
	}
}