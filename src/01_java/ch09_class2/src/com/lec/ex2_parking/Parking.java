package com.lec.ex2_parking;
//오늘의 워밍업3) 다음과 같은 결과가 나오도록 클래스를 정의하고 객체를 생성하도록 프로그램을 구현하세요
//주차장(ParkingSystem) 클래스 설계
//주차장 들어올 때 결과 : “11라1111”님 어서오세요
//                       입차시간 : 12시
//주차장 나갈 때 결과 : “11라1111”님 안녕히 가세요
//	             * 입차시간 : 12시
//		     * 출차시간 : 14시
//		     * 주차요금 : 4000원

import constant.Price;

public class Parking {
	private String carNum;
	private int inTime;
	private int outTime;
//	private final int HOURLYRATE = 2000; // 상수 , 종단 변수
	
	public Parking() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Parking(String carNum, int inTime) {
		System.out.printf("%s 님 어서오세요.\n 입차 시간 : %d 시\n\n", carNum, inTime);
		System.out.println("**************************");
		this.carNum = carNum;
		this.inTime = inTime;
	}
	public void outTime(int outTime) {
		System.out.printf(" %s 님 안녕히가세요.\n 입차시간 : %s 시 \n 출차시간 : %s 시 \n "
						+ "이용시간 : %s 시간 \n 주차 요금 : %s 원 \n\n", carNum, inTime, outTime, outTime - inTime, (outTime - inTime) * Price.HOURLYRATE);
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

