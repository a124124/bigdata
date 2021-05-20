package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		Amodel a = new Amodel();
		Bmodel b = new Bmodel();
		IAcorp c = new Cmodel();
		IAcorp[] phones = {a, b, c};
		
		for(IAcorp phone : phones) {
			phone.dmbReceive();
			phone.lte();
			phone.tvRemoteControl();
			System.out.println("----------------------");
		}
	}
}
