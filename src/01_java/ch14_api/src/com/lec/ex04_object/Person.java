package com.lec.ex04_object;

public class Person {
	private long juminNo; // 2105251010101
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		//p1.equals(p2) 호출할 경우 p1 대신 this. p2 대신 obj가 된다.
		// this.juminNo 와 obj의 juminNo가 같으면 true를 , 다르면 false를 return 하는걸 만들어본다.
		if(obj != null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
		
	}
}
