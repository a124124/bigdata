package com.lec.ex;
// return ���� ���� �޼ҵ�(�Լ�)
public class Ex04 {
	public static void main(String[] args) {
		printLine('��');
		System.out.println("Hello, World!");
		printLine();
		System.out.println("Hello, Java!");
		printLine('��',30); // ���� ���� ������ ���.
	}
	private static void printLine(char ch) {
		for(int i = 0; i < 20; i++) {
		System.out.print(ch);
		
		}
		System.out.println();
	}
			
	
	private static void printLine() {   //  - ���� 20�� ���.
		for(int i = 0; i < 20; i++) {
			System.out.print('-');
		}
		System.out.println(); //���� �߰�.
		
	}
	
	private static void printLine(char ch, int cnt) {
		for(int i = 0; i < cnt; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	
}
