package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex01_string.Friend;

public class Ex05 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String strToday = sdf.format(date);
		Friend[] friends = {new Friend("ȫ�浿", "010-1111-1111", "01-01"),
				new Friend("�ϱ浿", "010-2222-2222", "02-02"),
				new Friend("�̱浿", "010-3333-3333", "03-03"),
				new Friend("��浿", "010-4444-4444", "05-24"),
				new Friend("���浿", "010-5555-4444", "05-24")
		};
		// ���� ������ ģ���� ������ �� ģ�� ���
		// ������ ģ���� ������ ���ٰ� ���
		boolean outOk = false;
		
		for(int i = 0; i < friends.length; i++) {
			if(strToday.equals(friends[i].getBirthDay())) {
				System.out.println("���� ������ ����� �ֽ��ϴ�.");
				System.out.println(friends[i]);

				outOk = true;
			}
		
		}
		if(!outOk) {
			System.out.println("���� ������ ����� �����ϴ�.");
		}
	
	}
}