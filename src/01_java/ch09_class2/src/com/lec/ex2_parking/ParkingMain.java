package com.lec.ex2_parking;

public class ParkingMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("11��1111", 11);
		Parking car2 = new Parking("22��2222", 14);
		car1.outTime(23);
		car2.outTime(16);
	}
	
}

