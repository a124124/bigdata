package com.lec.ex01_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Ex03_login extends Frame {

	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;

	public Ex03_login(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		setLayout(new FlowLayout());
		lbl1 = new Label("�� �� ��");
		txtId = new TextField(20);
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); // �Է� �� *�� ��� ��µ�.
		btnLogin = new Button("LOGIN");
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));
		setLocation(100, 100);
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		new Ex03_login("�α���");
	}

}