package com.lec.ex03_store;
// 주택가에 매장1호점:  부대찌개-5,000  순대국-안팔아   kimchi bude bibim sunde bab
public class StoreNum1 implements HeadQuarterStore {
	private String name;
	public StoreNum1(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
		
	
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("순대국 : 안 팜");
		
	}


	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("김치찌개 : 5,500원");
	}


	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("비빔밥 : 6,000원");
	}


	@Override
	public void bab() {
		// TODO Auto-generated method stub
		System.out.println("공기밥 : 1,000원");
	}
	@Override
	public String getName() {
		return name;
	}

	
}
