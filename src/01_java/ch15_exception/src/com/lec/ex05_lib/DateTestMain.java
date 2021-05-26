package com.lec.ex05_lib;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateTestMain {
	public static void main(String[] args) {
//		Date outTime = new Date(121, 6, 30); // 1900년부터 시작하니 121, 0월부터 시작하니 월-1, 날짜는 그대로
		Date thatDay = new Date(new GregorianCalendar(2021, 4, 1).getTimeInMillis());
		System.out.println(thatDay);
		Date now = new Date();
		long diff = now.getTime() - thatDay.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		System.out.println("두 날짜 사이의 날짜 수는?" + day);
		if(day > 14) {
			long money = (day - 14) * 100;
			System.out.println(money + "원 연체료로 납부하셔야 합니다.");
		}
	}
	
}
