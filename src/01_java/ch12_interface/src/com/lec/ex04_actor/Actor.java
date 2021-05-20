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
		System.out.println(name + "은 범인을 잡을 수 있습니다.");
	}
	
	@Override
	public void canSearch() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 물건을 찾을 수 있습니다.");
	}
	
	@Override
	public void outFire() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 불을 끌 수 있습니다.");
	}
	
	@Override
	public void saveMan() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 사람을 구할 수 있습니다.");
	}

	@Override
	public void makePizza() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 피자를 만들 수 있습니다.");
	}

	@Override
	public void makeSpaghetti() {
		// TODO Auto-generated method stub
		System.out.println(name + "은 스파게티를 만들 수 있습니다.");
	}

}
