package com.lec.ex02;

public class Amodel implements IAcorp {
	private String model = "A모델";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 DMB 송수신이 가능합니다.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 5G입니다.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 TV리모콘이 탑재되어있습니다.");
	}
}
