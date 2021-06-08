package com.lec.ex02_date;
/*	Sawon Ŭ������ main�Լ��� ����ִ� �κ��� �����Ͽ� ������
	SawonŬ���� ����
	new Sawon("a01", "ȫ�浿", Part.COMPUTER)
	������ : ���, �̸�, �μ�(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), �Ի���.
	������ : ���, �̸�, �μ�, �Ի����� ��ü���� ���Ϸ� �մϴ�
	�޼ҵ�: infoString()�� �������� ������ �����ϴ�
	[���]200121  [�̸�]ȫ�浿  [�μ�]COMPUTER  [�Ի���]2019��2��2��
	main()�Լ����� Sawon ��ü ����� ȭ�鿡 print�� ������. ������ �Ի��� ����� ����մϴ�.

*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	private String num;
	private String name;
	private String part;
	private Date enterDate;
	
	public Sawon(String num, String name, String part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}
	
	

	public Sawon(String num, String name, String part, int y, int m, int d ) {
		super();
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� M�� d��");
		String temp = sdf.format(enterDate);
		if(part.length() > 10) {
			return "[���] " + num + "\t[�̸�] " + name + "\t[�μ�] " + part + "\t[�Ի���] " + temp;
		}
		return "[���] " + num + "\t[�̸�] " + name + "\t[�μ�] " + part + "\t\t[�Ի���] " + temp;
	}
	
	
	
}