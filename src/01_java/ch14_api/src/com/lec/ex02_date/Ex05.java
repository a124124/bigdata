package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex01_string.Friend;

public class Ex05 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String strToday = sdf.format(date);
		Friend[] friends = {new Friend("홍길동", "010-1111-1111", "01-01"),
				new Friend("일길동", "010-2222-2222", "02-02"),
				new Friend("이길동", "010-3333-3333", "03-03"),
				new Friend("사길동", "010-4444-4444", "05-24"),
				new Friend("오길동", "010-5555-4444", "05-24")
		};
		// 오늘 생일인 친구가 있으면 그 친구 출력
		// 생일인 친구가 없으면 없다고 출력
		boolean outOk = false;
		
		for(int i = 0; i < friends.length; i++) {
			if(strToday.equals(friends[i].getBirthDay())) {
				System.out.println("오늘 생일인 사람이 있습니다.");
				System.out.println(friends[i]);

				outOk = true;
			}
		
		}
		if(!outOk) {
			System.out.println("오늘 생일인 사람이 없습니다.");
		}
	
	}
}