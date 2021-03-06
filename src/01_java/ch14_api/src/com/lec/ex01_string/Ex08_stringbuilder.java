package com.lec.ex01_string;

public class Ex08_stringbuilder {
	public static void main(String[] args) {
		String st = "abc";
		StringBuilder stb = new StringBuilder("abc");
		System.out.println("1. " + stb);
		System.out.println(stb.hashCode());
		stb.append("def");
		System.out.println("2. " + stb);
		System.out.println(stb.hashCode());
		stb.insert(3, "AAA"); // 3번에 (4번째) AAA를 추가한다.
		System.out.println("3. " + stb);
		System.out.println(stb.hashCode());
		stb.delete(3, 6); // 3번부터 5번째까지를 지운다.(주의할것)
		System.out.println("4. "+ stb);
		System.out.println(stb.hashCode());
		int builderSize = stb.capacity();
		System.out.println(builderSize);
		System.out.println(stb.capacity());
		stb.append("56421564421564421564");
		System.out.println("5. " + stb);
		System.out.println(stb.hashCode());
		
		System.out.println(builderSize);
		System.out.println(stb.capacity());
	}
	
}
