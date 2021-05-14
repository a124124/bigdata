package com.lec.ex2_parking;
//������ ���־�3) ������ ���� ����� �������� Ŭ������ �����ϰ� ��ü�� �����ϵ��� ���α׷��� �����ϼ���
//������(ParkingSystem) Ŭ���� ����
//������ ���� �� ��� : ��11��1111���� �������
//                       �����ð� : 12��
//������ ���� �� ��� : ��11��1111���� �ȳ��� ������
//	             * �����ð� : 12��
//		     * �����ð� : 14��
//		     * ������� : 4000��

import constant.Price;

public class Parking {
	private String carNum;
	private int inTime;
	private int outTime;
//	private final int HOURLYRATE = 2000; // ��� , ���� ����
	
	public Parking() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Parking(String carNum, int inTime) {
		System.out.printf("%s �� �������.\n ���� �ð� : %d ��\n\n", carNum, inTime);
		System.out.println("**************************");
		this.carNum = carNum;
		this.inTime = inTime;
	}
	public void outTime(int outTime) {
		System.out.printf(" %s �� �ȳ���������.\n �����ð� : %s �� \n �����ð� : %s �� \n "
						+ "�̿�ð� : %s �ð� \n ���� ��� : %s �� \n\n", carNum, inTime, outTime, outTime - inTime, (outTime - inTime) * Price.HOURLYRATE);
		System.out.println("**************************");
	}
	
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}


	public int getHOURLYRATE() {
		return HOURLYRATE;
	}
	

		
	
}
