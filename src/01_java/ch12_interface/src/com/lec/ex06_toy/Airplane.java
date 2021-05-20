package com.lec.ex06_toy;

public class Airplane implements IMissile, ILight{
	public Airplane() {
		System.out.println("비행기 장난감");
		canMissile();
		canLight();
		System.out.println("---------------------");
	

}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	@Override
	public void canLight() {
		// TODO Auto-generated method stub
		System.out.println("불빛을 낼 수 있습니다.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "미사일을 쏘고 불빛을 낼 수 있는 비행기";
	}
}