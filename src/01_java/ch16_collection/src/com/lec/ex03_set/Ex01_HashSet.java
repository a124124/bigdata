package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		
		System.out.println(hashset);
		System.out.println(hashset.size());
		
		
		System.out.println("중복으로 add한경우");
		hashset.add("str0");
		hashset.add("str0");
		System.out.println(hashset);
		System.out.println(hashset.size());
		
		Iterator<String> iter = hashset.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
