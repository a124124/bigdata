package com.lec.ex02_map;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("ȫ�浿", new Friend("ȫ�浿", "9999-9999", new Date(90, 0, 5)));
		friends.put("�ű浿", new Friend("�ű浿", "9876-1234"));
		friends.put("���浿", new Friend("���浿", "3219-5321"));
		Iterator<String> iter = friends.keySet().iterator();
		
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + "�� ������ " + friends.get(key));
		}
		
	}
}