package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05_list extends Frame implements ActionListener {

	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List list;

	public Ex05_list() {
		// TODO Auto-generated constructor stub
		// layout����, ������Ʈ ����, add, setVisible, setSide ��� ����

		panel = new Panel(); // panel �� �⺻ ���̾ƿ��� new FlowLayout()
		txtField = new TextField(20);
		btnOk = new Button("ok");
		btnExit = new Button("Exit");
		list = new List();
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		setLocation(400, 600);
		// 1. implements ActionListener
		// 2. �̺�Ʈ ������ �߰�
		// 3. ���� �߰�
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnOk) {
			//
			list.add(txtField.getText());
			txtField.setText("");
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex05_list();
	}

}
