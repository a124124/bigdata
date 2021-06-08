package com.lec.ex04_object;

public class Person {
	private long juminNo; // 2105251010101
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		//p1.equals(p2) ȣ���� ��� p1 ��� this. p2 ��� obj�� �ȴ�.
		// this.juminNo �� obj�� juminNo�� ������ true�� , �ٸ��� false�� return �ϴ°� ������.
		if(obj != null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
		
	}
}