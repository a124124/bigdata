package com.lec.ex02_date;
/*	Sawon 클래스와 main함수가 들어있는 부분을 구현하여 보세요
	Sawon클래스 내용
	new Sawon("a01", "홍길동", Part.COMPUTER)
	데이터 : 사번, 이름, 부서(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), 입사일.
	생성자 : 사번, 이름, 부서, 입사일은 객체생성 당일로 합니다
	메소드: infoString()의 실행결과는 다음과 같습니다
	[사번]200121  [이름]홍길동  [부서]COMPUTER  [입사일]2019년2월2일
	main()함수에서 Sawon 객체 만들어 화면에 print해 보세요. 오늘이 입사한 사원도 출력합니다.

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
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 M월 d일");
		String temp = sdf.format(enterDate);
		if(part.length() > 10) {
			return "[사번] " + num + "\t[이름] " + name + "\t[부서] " + part + "\t[입사일] " + temp;
		}
		return "[사번] " + num + "\t[이름] " + name + "\t[부서] " + part + "\t\t[입사일] " + temp;
	}
	
	
	
}
