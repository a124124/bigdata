package com.lec.ex06_toy;

public class Airplane implements IMissile, ILight{
	public Airplane() {
		System.out.println("����� �峭��");
		canMissile();
		canLight();
		System.out.println("---------------------");
	

}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void canLight() {
		// TODO Auto-generated method stub
		System.out.println("�Һ��� �� �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�̻����� ��� �Һ��� �� �� �ִ� �����";
	}
}