package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01 extends Frame{
	private Button btn1;
	private Button btn2;
	public Ex01() {
		btn1 = new Button("버튼");
		btn2 = new Button("버튼2");
		// Frame 의 레이아웃 타입 :  BorderLayout (동, 서, 남, 북, 중)
		// 						FlowLayout (좌부터 우로, 위부터 아래로)
		//						GridLayout (행 열 지정)
		
		add(btn1, BorderLayout.EAST);  //BorderLayout 뒤에 방향을 꼭 정해줘야함.
		add(btn2, BorderLayout.SOUTH);
		
		setVisible(true);					// 윈도우창을 보이게함.
		setSize(new Dimension(350, 250)); // 크기 지정
		
		
		setLocation(300, 500);
		
		//3초 후 자동종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//종료
		setVisible(false);
		dispose();  // 프레임 컴포넌트의 자원해제 ( 종료 )
		System.exit(0);
		
	}
	public Ex01(String title) {
		this();
		setTitle(title);
		
	}
}
