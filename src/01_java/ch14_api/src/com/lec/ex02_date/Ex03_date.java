package com.lec.ex02_date;

import java.util.Date;

public class Ex03_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();              // 중앙에 실선이 생기면 곧 없어질 명령어라는것.
		System.out.printf("%d년 %d월 %d일\n", year, month, day);
		// %tY 년	 %tm 월 	%td 일 	%tH 24시	 %tl 12시	 %tp 오전/오후	 %tM 분	 %tS 초

		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tp %1$tl시 %1$tM분 %1$tS초", date);

	}
}
