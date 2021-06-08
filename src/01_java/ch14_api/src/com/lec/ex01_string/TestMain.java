package com.lec.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-1111-1111", "01-01"),
							new Friend("�ϱ浿", "010-2222-2222", "02-02"),
							new Friend("�̱浿", "010-3333-3333", "03-03"),
							new Friend("��浿", "010-4444-4444", "04-04"),
							new Friend("���浿", "010-5555-4444", "05-05")
		};
		
		boolean searchOk = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("��ȭ��ȣ �� 4�ڸ��� �Է��ϼ���(����� x)");
			String num = sc.next();
			if(num.equalsIgnoreCase("x")) {
				break;
			}
			searchOk = false;
			for(int i = 0; i < friends.length; i++) {
				String temp = friends[i].getPhone().substring(friends[i].getPhone().lastIndexOf("-") + 1);
				if(temp.equals(num)) {
					System.out.println(friends[i]);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("�Է��Ͻ� ��ȣ�� ���� ģ���� �����ϴ�");
			}
		}while(true);
		sc.close();
		System.out.println("����");
	}
}