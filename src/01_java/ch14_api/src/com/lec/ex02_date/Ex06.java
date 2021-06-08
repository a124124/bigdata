package com.lec.ex02_date;

import java.util.Calendar;

import com.lec.ex01_string.Friend;

public class Ex06 {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-1111-1111", "01-01"), new Friend("�ϱ浿", "010-2222-2222", "02-02"),
				new Friend("�̱浿", "010-3333-3333", "03-03"), new Friend("��浿", "010-4444-4444", "04-04"),
				new Friend("���浿", "010-5555-4444", "05-24") };
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String strMonth = (month < 10) ? "0" + month : String.valueOf(month);
		String strDay = (day < 10) ? "0" + day : "" + day;
		String strToday = strMonth + "-" + strDay;
		boolean outOk = false;

		for (int i = 0; i < friends.length; i++) {
			if (strToday.equals(friends[i].getBirthDay())) {
				System.out.println("���� ������ ����� �ֽ��ϴ�.");
				System.out.println(friends[i]);
				outOk = true;
			}

		}
		if (!outOk) {
			System.out.println("���� ������ ����� �����ϴ�.");
		}

	}
}