package com.lec.ex09_store;
// 반복작업 배열처리.
public class TestMain2 {	
	public static void main(String[] args) {
		HeadQuarterStore st1 = new HeadQuarterStore("본사");
		HeadQuarterStore[] store = {new HeadQuarterStore("본사"),
									new StoreNum1("주택가 1호점"),
									new StoreNum2("대학가 2호점"),
									new StoreNum3("증권가 3호점")
		};
		for(HeadQuarterStore i : store) { //확장 for문 
			System.out.println(i.getName());
			i.kimchi();
			i.bude();
			i.bibim();
			i.sunde();
			i.bab();
		}
//		for(int idx=0; idx < store.length; idx++) { // 일반 for문
//			System.out.println(store[idx].getName());
//			store[idx].kimchi();
//			store[idx].bude();
//			store[idx].bibim();
//			store[idx].sunde();
//			store[idx].bab();
//		}
	}
}
