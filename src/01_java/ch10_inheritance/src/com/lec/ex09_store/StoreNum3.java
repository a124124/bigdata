package com.lec.ex09_store;
//???ǰ??? ????3ȣ??: ??ġ?-6,000  ?δ??-7,000  ??????-7,000 ???뱹-6,000  
public class StoreNum3 extends HeadQuarterStore {

	public StoreNum3(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("??ġ? : 6,000??");
	}
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("?δ?? : 7,000??");
	}
	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("?????? : 7,000??");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("???뱹 : 6,000??");
	}
	
}
