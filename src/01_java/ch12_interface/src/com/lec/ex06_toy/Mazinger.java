package com.lec.ex06_toy;

public class Mazinger implements IMissile, IMoveArmLeg{
	public Mazinger() {
		System.out.println("��¡�� �峭��");
		canMissile();
		canMoveArmLeg();
		System.out.println("--------------------------");
	}
	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
		
	}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�̻����� ��� �ȴٸ��� ������ �� �ִ� ��¡��";
	}
}