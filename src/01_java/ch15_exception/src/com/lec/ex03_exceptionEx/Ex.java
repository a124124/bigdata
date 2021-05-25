package com.lec.ex03_exceptionEx;

public class Ex {
	public static void main(String[] args) {
		int no = 0;
		try {
			String strNo = " ";
			 no = Integer.parseInt(strNo.trim());
		}catch(NumberFormatException e) {
			
		}
		System.out.println(no+10);
	}
}
