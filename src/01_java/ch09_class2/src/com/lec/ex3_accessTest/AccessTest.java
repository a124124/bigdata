package com.lec.ex3_accessTest;

public class AccessTest {

		private int privateMember; // 같은 클래스 안에서만 사용 가능
		int defaultMember; // 디폴트 접근제한 : 같은 패키지 안에서만 사용 가능
		protected int protectedMember; // 같은 패키지와 상속받은 클래스에서 사용 가능
		public int publicMember; // 외부에서 아무나 사용 가능
		
		private void privateMethod() {
			System.out.println("privateMethod");
			
		}
		void defaultMethod() {
			System.out.println("defaultMethod");
		}
		protected void protectedMethod() {
			System.out.println("protectedMethod");
		}
		public void publicMethod() {
			System.out.println("publicMethod");
		}
		
}	
	
	

