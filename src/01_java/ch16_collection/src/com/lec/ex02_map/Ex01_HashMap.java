package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();  // int �� ��� ���ϰ� Integer �� ����Ѵ�.
		hashmap.put(11, "str0");
		hashmap.put(20, "str1");
		hashmap.put(33, "str30");
		
		System.out.println(hashmap.get(33));
		System.out.println(hashmap);
		System.out.println("----------------------");
		hashmap.remove(20);
		System.out.println(hashmap);
		hashmap.clear();
		System.out.println(hashmap.isEmpty() ? "������ ����" : "������ ����");
		hashmap.put(0, "Hong");
		hashmap.put(1, "Kim");
		hashmap.put(2, "Lee");
		hashmap.put(3, "Yoo");
		
		Iterator<Integer> it = hashmap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key + "�� �����ʹ� " + hashmap.get(key));
		}
		
	}
}
