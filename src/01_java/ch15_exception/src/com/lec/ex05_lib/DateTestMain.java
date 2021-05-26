package com.lec.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateTestMain {
	public static void main(String[] args) {
//		Date outTime = new Date(121, 6, 30); // 1900����� �����ϴ� 121, 0������ �����ϴ� ��-1, ��¥�� �״��
		Date thatDay = new Date(new GregorianCalendar(2021, 4, 1).getTimeInMillis());
		System.out.println(thatDay);
		Date now = new Date();
		long diff = now.getTime() - thatDay.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		System.out.println("�� ��¥ ������ ��¥ ����?" + day);
		if(day > 14) {
			long money = (day - 14) * 100;
			System.out.println(money + "�� ��ü��� �����ϼž� �մϴ�.");
		}
	}
	
}
