package com.lec.ex02_throws;

public class Main {
	public static void main(String[] args){
		try {
			new ThrowsEx();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
