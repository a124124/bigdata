package com.lec.ex06_toy;

public class Mazinger implements IMissile, IMoveArmLeg{
	public Mazinger() {
		System.out.println("마징가 장난감");
		canMissile();
		canMoveArmLeg();
		System.out.println("--------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("팔다리를 움직일 수 있습니다.");
		
	}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("미사일을 쏠 수 있습니다.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "미사일을 쏘고 팔다리를 움직일 수 있는 마징가";
	}
}
