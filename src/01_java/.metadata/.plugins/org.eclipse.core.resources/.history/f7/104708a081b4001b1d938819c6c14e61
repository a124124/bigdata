package com.lec.ex5_momChild;
// Child first = new Child("첫째");
// first.takeMoney(1000); 
// first.momPouch.money 가 2천원
public class Child {
	private String name; 
	MomPouch momPouch = new MomPouch();
	
	public Child(String name) {
		this.name = name;
	}

	public Child() {
		// TODO Auto-generated constructor stub
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
//			momPouch.money = momPouch.money - money;
			momPouch.money -= money;
			System.out.println(name + "가" + money + "원 가져가서 엄마돈은 " + momPouch.money + "원 남음");
		}else {
			System.out.println(name + "은 돈을 못받음. 엄마돈은 " + momPouch.money +"원");
		}
	}
	
}
