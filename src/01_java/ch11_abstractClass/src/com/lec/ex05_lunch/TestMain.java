package com.lec.ex05_lunch;

import cons.PriceTable;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child1 c1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, PriceTable.BANANA, PriceTable.ALMOND, PriceTable.MILK);
		Child2 c2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, PriceTable.BANANA, PriceTable.ALMOND, PriceTable.MILK);
		System.out.println(c1.getTypeString() + c1.calculate());
		System.out.println(c2.getTypeString() + c2.calculate());
		
	}

}
