package com.lec.ex02;

public class Bmodel implements IAcorp{
	private String model = "B��";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� DMB �ۼ����� �����մϴ�.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� LTE�Դϴ�.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� TV�������� ž��Ǿ��ֽ��ϴ�.");
	}

}