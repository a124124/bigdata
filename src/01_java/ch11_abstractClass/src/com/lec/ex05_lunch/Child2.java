package com.lec.ex05_lunch;

public class Child2 extends LunchMenu {

	public Child2(int rice, int bulgogi, int soup, int banana, int almond, int milk) {
		super(rice, bulgogi, soup, banana, almond, milk);
		// TODO Auto-generated constructor stub
		setTypeString("child2Çü");
	}

	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		return getRice() + getBulgogi() + getSoup() + getMilk();
		
	}

}
