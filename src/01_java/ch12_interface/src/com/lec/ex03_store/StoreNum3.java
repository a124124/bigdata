package com.lec.ex03_store;
//���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000   kimchi bude bibim sunde bab
public class StoreNum3 implements HeadQuarterStore {
	private String name;
	public StoreNum3(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("��ġ� : 6,500��");
	}
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("�δ�� : 7,000��");
	}
	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("����� : 7,000��");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("���뱹 : 6,500��");
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
