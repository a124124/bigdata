package com.lec.ex02_date;

import java.util.Date;

public class Ex03_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();              // �߾ӿ� �Ǽ��� ����� �� ������ ���ɾ��°�.
		System.out.printf("%d�� %d�� %d��\n", year, month, day);
		// %tY ��	 %tm �� 	%td �� 	%tH 24��	 %tl 12��	 %tp ����/����	 %tM ��	 %tS ��

		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tp %1$tl�� %1$tM�� %1$tS��", date);

	}
}