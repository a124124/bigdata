package com.lec.ex05_lunch;

public class Child1 extends LunchMenu {


	public Child1(int rice, int bulgogi, int soup, int banana, int almond, int milk) {
		super(rice, bulgogi, soup, banana, almond, milk);
		// TODO Auto-generated constructor stub
		setTypeString("child1형");
	}

	@Override
	public int calculate() {  //Child1 형의 아이는 간식으로 바나나와 아몬드를 먹습니다.
		// TODO Auto-generated method stub
		return getRice() + getBulgogi() + getSoup() + getBanana() + getAlmond();
	}

}
