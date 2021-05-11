package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i = 10 ; // 4byte 짜리 정수 i 주머니에 10을 할당 
		byte j = 20 ; // 1byte 짜리 정수 j 주머니에 20을 할당
		double d = 1 ; // 8byte 짜리 실수 d 주머니에 0.1을 할당
		char c = 'C' ; // 2byte 짜리 문자 c 주머니에 'C'를 할당
		boolean ok = true ; // boolean 에는 true 아니면 false 밖에 할당되지 않는다.
		long l = 2200000000L ;
		System.out.println("i\t j\t d");  // \t 는 탭
		System.out.println(i+"\t"+j+"\t"+d); // println 은 개행해서 출력
		System.out.println("c\t c");	//print는 개행이 되지 않음
		System.out.println("변수 c의 값과 코드\n");			// \n 은 개행
		System.out.printf("c=%c , c의 코드값=%d\n", c, (int)c);
		System.out.println(ok);
		System.out.printf("ok=%b=n", ok);
		System.out.printf("l=%d", l);
		System.out.printf("d=%5.2f", d);
		
		// %d (정수) %f(실수) %b(불린,true or false) %x (16진수) %c (문자 1개) %s (문자열)
	}
}
