package com.lec.ex06_toy;

public class Pooh implements IMoveArmLeg{
	public Pooh() {
		System.out.println("?????? Ǫ?Դϴ?.");
		canMoveArmLeg();
		System.out.println("-------------------");
	}
	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("?ȴٸ??? ?????? ?? ?ֽ??ϴ?.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "?ȴٸ??? ?????̴? ?????? Ǫ";
	}
	
}
