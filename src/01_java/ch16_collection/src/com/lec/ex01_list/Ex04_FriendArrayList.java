package com.lec.ex01_list;

import java.sql.Date;
import java.util.ArrayList;

import com.lec.ex02_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
//		Friend[] friends = {new Friend("가길동", "9999-9999", new Date(100, 2, 1)),
//							new Friend("나길동", "9999-8888", new Date(100, 4, 21))
//		};
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("가길동", "9999-9999", new Date(100, 2, 1)));
		friends.add(new Friend("나길동", "9999-8888", new Date(100, 4, 21)));
		System.out.println(friends);
		for(int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}
		System.out.println("----------------");
		for(Friend f : friends) {
			System.out.println(f);
		}
	}
}
