package com.lec.ex03_store;
// ���ð��� ����1ȣ��:  �δ��-5,000  ���뱹-���Ⱦ�   kimchi bude bibim sunde bab
public class StoreNum1 implements HeadQuarterStore {
	private String name;
	public StoreNum1(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
		
	
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("���뱹 : �� ��");
		
	}


	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("��ġ� : 5,500��");
	}


	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("����� : 6,000��");
	}


	@Override
	public void bab() {
		// TODO Auto-generated method stub
		System.out.println("����� : 1,000��");
	}
	@Override
	public String getName() {
		return name;
	}

	
}
