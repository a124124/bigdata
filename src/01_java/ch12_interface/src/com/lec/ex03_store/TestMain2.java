package com.lec.ex03_store;
// �ݺ��۾� �迭ó��.
public class TestMain2 {	
	public static void main(String[] args) {
		HeadQuarterStore[] store = {
									new StoreNum1("���ð� 1ȣ��"),
									new StoreNum2("���а� 2ȣ��"),
									new StoreNum3("���ǰ� 3ȣ��")
		};
		for(HeadQuarterStore i : store) { //Ȯ�� for�� 
			System.out.println(i.getName());
			i.kimchi();
			i.bude();
			i.bibim();
			i.sunde();
			i.bab();
		}
//		for(int idx=0; idx < store.length; idx++) { // �Ϲ� for��
//			System.out.println(store[idx].getName());
//			store[idx].kimchi();
//			store[idx].bude();
//			store[idx].bibim();
//			store[idx].sunde();
//			store[idx].bab();
//		}
	}
}