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
			
			System.out.println("ȸ������ ������ �Է��Ϸ��� �ƹ� Ű�� �Է��ϼ��� (����� n)");
			
			String fn = sc.next();
			
			if (fn.equalsIgnoreCase("n")) {
				if (customer.isEmpty()) {
					System.out.println("�Էµ� ȸ���� �����ϴ�.");
					break;
				} else {
					System.out.println(customer);
					break;
				}
			} else {
				sc.nextLine();
				System.out.println("�̸� �Է�");
				name = sc.nextLine();
				System.out.println("��ȭ��ȣ");
				tel = sc.nextLine();
				System.out.println("�ּ�");
				address = sc.nextLine();
				customer.add(new Customer(name, tel, address));
				
			}
			
		}while(true);
		sc.close();
		System.out.println("����");
		
	}
}