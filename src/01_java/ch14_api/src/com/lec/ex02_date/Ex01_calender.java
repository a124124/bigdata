package com.lec.ex02_date;

import java.util.Calendar;

public class Ex01_calender {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 시스템은 0월부터
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1(일) 2(월) ... 7(토)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); 
		int hour = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM); // 0(오전) 1(오후)
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch (week) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		System.out.printf("%d시 %d분 %d초(24시간단위)\n" , hour24, minute, second);
		System.out.println(ampm != 0 ? "오후 " : "오전");
		System.out.printf("%d시 %d분 %d초\n" , hour, minute, second);
		// %tY 년	 %tm 월 	%td 일 	%tH 24시	 %tl 12시	 %tp 오전/오후	 %tM 분	 %tS 초
		System.out.printf("%tY년 %tm월 %td일 %tH시 %tM분 %tS초\n", cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tp %1$tl시 %1$tM분 %1$tS초", cal);
		
	}
	
}
