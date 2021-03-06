package com.lec.ex01_string;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		String[] nums = {"010-9999-9999",
						"010-8888-8888",
						"010-8777-7777",
						"010-5525-7777",
						"010-5212-6666"
		};
		boolean searchOk = false; // 전화번호 뒷자리 검색해서 검색이 된 경우 true, 
		Scanner sc = new Scanner(System.in);
		// 사용자가 x를 입력할때까지 전화번호 검색
		do {
			
			System.out.println("전화번호 뒤 4자리 검색(종료를 원하면 x를 누르세요)");
			String num = sc.next();
			if(num.equalsIgnoreCase("x")) {
				break;
			}
			searchOk = false;
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
		}while(true);
		System.out.println("종료");
	}
}
