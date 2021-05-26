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
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일");
		
		if(birth != null) {
			return name + "의 연락처 : " + tel + ", 생일 : " + sdf.format(birth);
		} else {
			return name + "의 연락처 : " + tel;
		}
	}
	
}
