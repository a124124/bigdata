package com.lec.ex3_accessTest;

public class AccessTest {

		private int privateMember; // ���� Ŭ���� �ȿ����� ��� ����
		int defaultMember; // ����Ʈ �������� : ���� ��Ű�� �ȿ����� ��� ����
		protected int protectedMember; // ���� ��Ű���� ��ӹ��� Ŭ�������� ��� ����
		public int publicMember; // �ܺο��� �ƹ��� ��� ����
		
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
	
	

