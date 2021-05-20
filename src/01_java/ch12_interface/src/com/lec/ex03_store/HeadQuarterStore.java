package com.lec.ex03_store;
//        본사 지침         : 김치찌개- 0 부대찌개- 0  비빔밥- 0 순대국- 0  공기밥- 0
public interface HeadQuarterStore {  //추상 메소드가 1개라도 있으면 추상 클래스가 된다. abstract 가 필요.
	
	public abstract void kimchi();  // 추상 메소드
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void bab();
	public String getName();
	}
	
	
	

