package com.lec.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gc {
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // �ý����� 0������
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1(��) 2(��) ... 7(��)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); 
		int hour = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM); // 0(����) 1(����)
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d�� %d�� %d�� ", year, month, day);
		switch (week) {
		case 1:
			System.out.println("�Ͽ���");
			break;
		case 2:
			System.out.println("������");
			break;
		case 3:
			System.out.println("ȭ����");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("�����");
			break;
		case 6:
			System.out.println("�ݿ���");
			break;
		case 7:
			System.out.println("�����");
			break;
		}
		System.out.printf("%d�� %d�� %d��(24�ð�����)\n" , hour24, minute, second);
		System.out.println(ampm != 0 ? "���� " : "����");
		System.out.printf("%d�� %d�� %d��\n" , hour, minute, second);
		// %tY ��	 %tm �� 	%td �� 	%tH 24��	 %tl 12��	 %tp ����/����	 %tM ��	 %tS ��
		System.out.printf("%tY�� %tm�� %td�� %tH�� %tM�� %tS��\n", cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tp %1$tl�� %1$tM�� %1$tS��", cal);
		
	}
	
}