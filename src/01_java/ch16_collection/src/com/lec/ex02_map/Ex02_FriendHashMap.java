package com.lec.ex02_map;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("홍길동", new Friend("홍길동", "9999-9999", new Date(90, 0, 5)));
		friends.put("신길동", new Friend("신길동", "9876-1234"));
		friends.put("나길동", new Friend("나길동", "3219-5321"));
		Iterator<String> iter = friends.keySet().iterator();
		
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + "의 데이터 " + friends.get(key));
		}
		
	}
}
