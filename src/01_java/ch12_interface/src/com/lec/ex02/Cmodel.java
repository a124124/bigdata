package com.lec.ex02;

public class Cmodel implements IAcorp{
	private String model = "C모델";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 DMB 송수신이 불가능합니다.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 LTE입니다.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "은 TV리모콘이 미탑재되어있습니다.");
	}

}
