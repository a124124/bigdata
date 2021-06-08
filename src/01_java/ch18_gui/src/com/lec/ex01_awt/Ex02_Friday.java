package com.lec.ex01_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// �̺�Ʈ : 1. implements ActionListner �� �����Ѵ�. 2. @Override 3. ������Ʈ�� Listener �߰�. 4. Override �� ���� 
public class Ex02_Friday extends Frame implements ActionListener{
	private Label lbl1;  // �߰��� ������Ʈ�� ���� ����
	private Button btnExit;
	public Ex02_Friday(String title) {
		super(title);
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(2,2));
		lbl1 = new Label("��ſ� �ݿ���");
		lbl1.setPreferredSize(new Dimension(150,250));
		btnExit = new Button("����");
		btnExit.setPreferredSize(new Dimension(200,200));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setSize(new Dimension(500,400));
		setLocation(100,100);
		
		
		// btnExit Ŭ�� �̺�Ʈ�� �߰��Ѵ�.
		btnExit.addActionListener(this); // this.actionPerformed() �� ȣ��ȴ�.
		
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