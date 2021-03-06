package com.lec.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-1111-1111", "01-01"),
							new Friend("일길동", "010-2222-2222", "02-02"),
							new Friend("이길동", "010-3333-3333", "03-03"),
							new Friend("사길동", "010-4444-4444", "04-04"),
							new Friend("오길동", "010-5555-4444", "05-05")
		};
		
		boolean searchOk = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("전화번호 뒤 4자리를 입력하세요(종료는 x)");
			String num = sc.next();
			if(num.equalsIgnoreCase("x")) {
				break;
			}
			searchOk = false;
			for(int i = 0; i < friends.length; i++) {
				String temp = friends[i].getPhone().substring(friends[i].getPhone().lastIndexOf("-") + 1);
				if(temp.equals(num)) {
					System.out.println(friends[i]);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("입력하신 번호를 가진 친구는 없습니다");
			}
		}while(true);
		sc.close();
		System.out.println("종료");
	}
}
