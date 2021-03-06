package com.lec.ex01_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 이벤트 : 1. implements ActionListner 를 구현한다. 2. @Override 3. 컴포넌트에 Listener 추가. 4. Override 에 로직 
public class Ex02_Friday extends Frame implements ActionListener{
	private Label lbl1;  // 추가할 컴포넌트를 변수 선언
	private Button btnExit;
	public Ex02_Friday(String title) {
		super(title);
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(2,2));
		lbl1 = new Label("즐거운 금요일");
		lbl1.setPreferredSize(new Dimension(150,250));
		btnExit = new Button("종료");
		btnExit.setPreferredSize(new Dimension(200,200));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500,400));
		setLocation(100,100);
		
		
		// btnExit 클릭 이벤트를 추가한다.
		btnExit.addActionListener(this); // this.actionPerformed() 가 호출된다.
		
	}
	public Ex02_Friday() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}

}
