package com.lec.ex04_actor;

public class Actor implements IPoliceMan, IFireFighter, IChef {
	private String name;
	
	public Actor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public void canCatchCriminal() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ������ ���� �� �ֽ��ϴ�.");
	}
	
	@Override
	public void canSearch() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ������ ã�� �� �ֽ��ϴ�.");
	}
	
	@Override
	public void outFire() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ���� �� �� �ֽ��ϴ�.");
	}
	
	@Override
	public void saveMan() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ����� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makePizza() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ���ڸ� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makeSpaghetti() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� ���İ�Ƽ�� ���� �� �ֽ��ϴ�.");
	}

}
