package com.lec.ex02_map;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Friend {
	private String name;
	private String tel;
	private Date birth;
	
	public Friend() {
		
	}
	
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("MM�� dd��");
		
		if(birth != null) {
			return name + "�� ����ó : " + tel + ", ���� : " + sdf.format(birth);
		} else {
			return name + "�� ����ó : " + tel;
		}
	}
	
}