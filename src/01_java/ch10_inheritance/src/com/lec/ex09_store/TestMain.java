package com.lec.ex09_store;
// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore st = new HeadQuarterStore("����");
		System.out.println(st.getName());
		st.kimchi();
		st.bude();
		st.bibim();
		st.sunde();
		st.bab();
		StoreNum1 st1 = new StoreNum1("���ð� 1ȣ��");
		System.out.println(st1.getName());
		st1.kimchi();
		st1.bude();
		st1.bibim();
		st1.sunde();
		st1.bab();
		
	}
}
