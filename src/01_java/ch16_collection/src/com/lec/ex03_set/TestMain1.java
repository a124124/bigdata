package com.lec.ex03_set;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		String name;
		String tel;
		String address;
		
		do {
			
			System.out.println("회원가입 정보를 입력하려면 아무 키를 입력하세요 (종료는 n)");
			
			String fn = sc.next();
			
			if (fn.equalsIgnoreCase("n")) {
				if (customer.isEmpty()) {
					System.out.println("입력된 회원이 없습니다.");
					break;
				} else {
					System.out.println(customer);
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
				customer.add(new Customer(name, tel, address));
				
			}
			
		}while(true);
		sc.close();
		System.out.println("종료");
		
	}
}
