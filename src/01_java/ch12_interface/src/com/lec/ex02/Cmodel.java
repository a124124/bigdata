package com.lec.ex02;

public class Cmodel implements IAcorp{
	private String model = "C��";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� DMB �ۼ����� �Ұ����մϴ�.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� LTE�Դϴ�.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� TV�������� ��ž��Ǿ��ֽ��ϴ�.");
	}

}
