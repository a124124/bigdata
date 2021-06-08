package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_simpleDateFormat {
	public static void main(String[] args) {
		Date now1 = new Date();
		Calendar now2 = Calendar.getInstance();
		GregorianCalendar now3 = new GregorianCalendar();
		// yyyy(�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�) M(5) MM(05) d(5) dd(05)
		// E(����) a (���� ����) H(24�ð�) h(12�ð�) m(��) s(��) ms(�и���)
		// w(�̹� �⵵�� ���° ��) W(�̹� ���� ���° ��) D(������ ���° ��)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		System.out.println(sdf.format(now1));
		System.out.println(sdf.format(now2.getTime()));
		System.out.println(sdf.format(now3.getTime()));
		
		
		}
}