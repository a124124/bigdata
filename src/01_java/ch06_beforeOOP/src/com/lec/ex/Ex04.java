package com.lec.ex;
// return 값이 없는 메소드(함수)
public class Ex04 {
	public static void main(String[] args) {
		printLine('■');
		System.out.println("Hello, World!");
		printLine();
		System.out.println("Hello, Java!");
		printLine('■',30); // 가는 라인 한줄을 출력.
	}
	private static void printLine(char ch) {
		for(int i = 0; i < 20; i++) {
		System.out.print(ch);
		
		}
		System.out.println();
	}
			
	
	private static void printLine() {   //  - 라인 20개 출력.
		for(int i = 0; i < 20; i++) {
			System.out.print('-');
		}
		System.out.println(); //개행 추가.
		
	}
	
	private static void printLine(char ch, int cnt) {
		for(int i = 0; i < cnt; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	
}
