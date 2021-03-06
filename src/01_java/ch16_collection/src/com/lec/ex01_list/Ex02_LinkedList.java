package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); // 0번 인덱스
		linkedList.add("str1"); // 1번 이었지만 linkedList.add(1, "1111"); 이후로 2번이됨.
		linkedList.add("str2"); // 2번이었지만 linkedList.add(1, "1111"); 이후로 3번이됨
		linkedList.add(1, "1111"); 
		System.out.println(linkedList);
		for(String lk : linkedList) {
			System.out.println(lk);
		}
		linkedList.remove("1111");
		System.out.println("- remove 후 -");
		for(int i = 0; i < linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}
		linkedList.clear();
		System.out.println(linkedList.isEmpty() ? "비워짐" : "안비워짐");
	}
}
