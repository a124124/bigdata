package com.lec.ex03_store;
// ���а��� ����2ȣ��:  �δ��-5,000  �����-5,000  �����-���� kimchi bude bibim sunde bab
public class StoreNum2 implements HeadQuarterStore{
	private String name;
	public StoreNum2(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("�δ�� : 4,000��");
	}
	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("����� : 4,000��");
	}
	@Override
	public void bab() {
		// TODO Auto-generated method stub
		System.out.println("����� : ����");
	}
	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("��ġ� : 4,000��");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("���뱹 : 4,000��");
	}
	@Override
	public String getName() {
		return name;
	}
	
}
