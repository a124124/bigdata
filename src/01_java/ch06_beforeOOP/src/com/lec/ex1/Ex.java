package com.lec.ex1;
import com.lec.ex.Arithmatic;

// 다른 패키지에 있는 class 를 사용할 경우 import 를 한다.(Scanner 와 같이)

public class Ex {
	public static void main(String[] args) {
	
		Arithmatic ar = new Arithmatic();
		System.out.println(ar.sum(1,66));
		
		// default 접근제한자일 경우 같은 패키지에서만 사용 가능
		
	}
	
	
	
}
