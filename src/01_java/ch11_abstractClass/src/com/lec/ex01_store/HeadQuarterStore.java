package com.lec.ex01_store;
//        ���� ��ħ         : ��ġ�- 0 �δ��- 0  �����- 0 ���뱹- 0  �����- 0
public abstract class HeadQuarterStore {  //�߻� �޼ҵ尡 1���� ������ �߻� Ŭ������ �ȴ�. abstract �� �ʿ�.
	private String name;
	
	public HeadQuarterStore(String name) {
		this.name = name;
	}
	public abstract void kimchi();  // �߻� �޼ҵ�
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void bab();
	public String getName() {
		return name;
	}
	
	
	
}
