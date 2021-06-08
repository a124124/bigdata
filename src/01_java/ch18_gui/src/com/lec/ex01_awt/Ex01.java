package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex01 extends Frame{
	private Button btn1;
	private Button btn2;
	public Ex01() {
		btn1 = new Button("��ư");
		btn2 = new Button("��ư2");
		// Frame �� ���̾ƿ� Ÿ�� :  BorderLayout (��, ��, ��, ��, ��)
		// 						FlowLayout (�º��� ���, ������ �Ʒ���)
		//						GridLayout (�� �� ����)
		
		add(btn1, BorderLayout.EAST);  //BorderLayout �ڿ� ������ �� ���������.
		add(btn2, BorderLayout.SOUTH);
		
		setVisible(true);					// ������â�� ���̰���.
		setSize(new Dimension(350, 250)); // ũ�� ����
		
		
		setLocation(300, 500);
		
		//3�� �� �ڵ�����
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//����
		setVisible(false);
		dispose();  // ������ ������Ʈ�� �ڿ����� ( ���� )
		System.exit(0);
		
	}
	public Ex01(String title) {
		this();
		setTitle(title);
		
	}
}