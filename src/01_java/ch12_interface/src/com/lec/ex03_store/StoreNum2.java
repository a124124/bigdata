package com.lec.ex03_store;
// ´ëÇĞ°¡¿¡ ¸ÅÀå2È£Á¡:  ºÎ´ëÂî°³-5,000  ºñºö¹ä-5,000  °ø±â¹ä-¹«·á kimchi bude bibim sunde bab
public class StoreNum2 implements HeadQuarterStore{
	private String name;
	public StoreNum2(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void bude() {
		// TODO Auto-generated method stub
		System.out.println("ºÎ´ëÂî°³ : 4,000¿ø");
	}
	@Override
	public void bibim() {
		// TODO Auto-generated method stub
		System.out.println("ºñºö¹ä : 4,000¿ø");
	}
	@Override
	public void bab() {
		// TODO Auto-generated method stub
		System.out.println("°ø±â¹ä : ¹«·á");
	}
	@Override
	public void kimchi() {
		// TODO Auto-generated method stub
		System.out.println("±èÄ¡Âî°³ : 4,000¿ø");
	}
	@Override
	public void sunde() {
		// TODO Auto-generated method stub
		System.out.println("¼ø´ë±¹ : 4,000¿ø");
	}
	@Override
	public String getName() {
		return name;
	}
	
}
