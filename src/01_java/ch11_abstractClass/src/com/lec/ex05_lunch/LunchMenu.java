package com.lec.ex05_lunch;

public abstract class LunchMenu {
	private String typeString; // 어린이 타입.
	private int rice;  //밥값(1인)
	private int bulgogi; // 불고기값
	private int soup;	//국값
	private int banana;	//바나나값
	private int almond;	//아몬드값
	private int milk;	//우유값
	
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int almond, int milk) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.almond = almond;
		this.milk = milk;
	}
	public abstract int calculate(); //식대 계산 메소드.
	
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	public int getRice() {
		return rice;
	}
	public void setRice(int rice) {
		this.rice = rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public void setBulgogi(int bulgogi) {
		this.bulgogi = bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public void setSoup(int soup) {
		this.soup = soup;
	}
	public int getBanana() {
		return banana;
	}
	public void setBanana(int banana) {
		this.banana = banana;
	}
	public int getAlmond() {
		return almond;
	}
	public void setAlmond(int almond) {
		this.almond = almond;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	
	
}
