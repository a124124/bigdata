package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		String[] nums = {"010-9999-9999",
						"010-8888-8888",
						"010-8777-7777",
						"010-5525-7777",
						"010-5212-6666"
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호 뒤 4자리 검색");
		//
		String num = sc.next();
		boolean searchOk = false; // 전화번호 뒷자리 검색해서 검색이 된 경우 true, 
		for(int i = 0; i < nums.length ; i++) {
			String temp = nums[i].substring(nums[i].lastIndexOf("-") + 1);
			if(temp.equals(num)) {
				System.out.println(nums[i]);
				searchOk = true;
				
			}
		}
		if(!searchOk) {
			System.out.println("입력하신 번호는 없는 번호입니다.");
		}
		
		
	}
}
