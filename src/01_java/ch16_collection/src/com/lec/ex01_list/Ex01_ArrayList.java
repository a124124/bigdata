package com.lec.ex01_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "sta2";
		
		for(int i = 0; i < array.length; i++) {
			System.out.printf("array[%s] = %s\n", i, array);
		}
		for(String arr : array) {
			System.out.print(arr + "\t");
		}
		System.out.println("----------------------");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 이었지만 arrayList.add(1,"11111"); 이후로 2번이됨. 
		arrayList.add("str2"); // 2번이었지만 arrayList.add(1,"11111"); 이후로 3번이 됨.
		arrayList.add(1,"11111"); // 넣고싶은 자리, 넣을 값
		arrayList.set(1, "cstr1");
		
		for(String arr : arrayList) {
			System.out.print(arr + "\t");
		}
		
		System.out.println("\n - remove 한 후에 - ");
		arrayList.remove(1); // 1번째 인덱스의 데이터가 삭제됨. 그러면 2번이 1번으로 이동, 3번이 2번으로 이동
		arrayList.remove(arrayList.size()-1);  // 맨 마지막 인덱스 삭제
		
		
		for(int i = 0; i < arrayList.size(); i++) {
			System.out.printf("%d번째 인덱스 값은 : %s\t", i, arrayList.get(i));
		}
		System.out.println();
		System.out.println(arrayList);
		System.out.println(arrayList.toString());
		arrayList.clear(); // arrayList의 모든 데이터 삭제
		if(arrayList.size() == 0) {
			System.out.println("arrayList 의 데이터는 없습니다");
		
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList 의 데이터가 비워짐");
		}
		System.out.println(arrayList);
		
		arrayList = null; // arrayList 를 아예 지워버림.
//		System.out.println(arrayList.size());
	}
}
