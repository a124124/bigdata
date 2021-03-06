package com.lec.ex03_set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, Customer> hash = new HashMap<String, Customer>();
		Scanner sc = new Scanner(System.in);
		String name;
		String tel;
		String address;
		
		do {
			System.out.println("회원가입하려면 아무키를, 종료는 n을 입력하세요.");
			String fn = sc.next();
			if(fn.equalsIgnoreCase("n")) {
				if(hash.isEmpty()) {
					System.out.println("입력된 회원이 없습니다");
					break;
				}else {
					Iterator<String> iter = hash.keySet().iterator();
					while(iter.hasNext()) {
						String key = iter.next();
						System.out.println(hash.get(key));
					}
					break;
				}
			} else {
				sc.nextLine();
				System.out.println("이름 입력");
				name = sc.nextLine();
				System.out.println("전화번호");
				tel = sc.nextLine();
				System.out.println("주소");
				address = sc.nextLine();
				hash.put(tel, new Customer(name, tel, address));
			}
			
		}while(true);
		sc.close();
		System.out.println("종료");
		
	}
}
