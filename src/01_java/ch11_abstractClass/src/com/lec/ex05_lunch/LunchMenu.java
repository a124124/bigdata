package com.lec.ex05_lunch;

public abstract class LunchMenu {
	private String typeString; // ��� Ÿ��.
	private int rice;  //�䰪(1��)
	private int bulgogi; // �Ұ��Ⱚ
	private int soup;	//����
	private int banana;	//�ٳ�����
	private int almond;	//�Ƹ�尪
	private int milk;	//������
	
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int almond, int milk) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.almond = almond;
		this.milk = milk;
	}
	public abstract int calculate(); //�Ĵ� ��� �޼ҵ�.
	
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