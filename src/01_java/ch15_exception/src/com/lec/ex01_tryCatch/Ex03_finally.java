package com.lec.ex01_tryCatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] iArr = {0, 1, 2};
		for(int i = 0; i <= iArr.length; i++) {
			try {
				System.out.printf("iArr[%d] = %d\n", i, iArr[i]);
				
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외메세지 : " + e.getMessage());
			}finally {
				System.out.println("try절 실행 후에도, catch절 실행 후에도 반드시 실행하는 명령어가 finally");
			}
		}
	}
}
