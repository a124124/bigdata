package com.lec.ex02;

public class Bmodel implements IAcorp{
	private String model = "B모델";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 DMB 송수신이 가능합니다.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 LTE입니다.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 TV리모콘이 탑재되어있습니다.");
	}

}
