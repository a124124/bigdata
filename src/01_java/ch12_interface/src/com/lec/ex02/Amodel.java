package com.lec.ex02;

public class Amodel implements IAcorp {
	private String model = "A��";
	@Override
	public void dmbReceive() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� DMB �ۼ����� �����մϴ�.");
	}

	@Override
	public void lte() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� 5G�Դϴ�.");
	}

	@Override
	public void tvRemoteControl() {
		// TODO Auto-generated method stub
		System.out.println(model + "�� TV�������� ž��Ǿ��ֽ��ϴ�.");
	}
}