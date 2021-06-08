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
			System.out.println("ȸ�������Ϸ��� �ƹ�Ű��, ����� n�� �Է��ϼ���.");
			String fn = sc.next();
			if(fn.equalsIgnoreCase("n")) {
				if(hash.isEmpty()) {
					System.out.println("�Էµ� ȸ���� �����ϴ�");
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
				System.out.println("�̸� �Է�");
				name = sc.nextLine();
				System.out.println("��ȭ��ȣ");
				tel = sc.nextLine();
				System.out.println("�ּ�");
				address = sc.nextLine();
				hash.put(tel, new Customer(name, tel, address));
			}
			
		}while(true);
		sc.close();
		System.out.println("����");
		
	}
}