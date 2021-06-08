package com.lec.ex02_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_GUI extends JFrame implements ActionListener {
	private Container container;
	private JPanel jp;
	private JTextField jtxtName;
	private JTextField jtxtTel;
	private JTextField jtxtAge;
	private ImageIcon icon;
	private JButton jbtnOut;
	private JTextArea jta;
	private JScrollPane scroll;
	private ArrayList<Friend> friends;
	
	
	
	public Ex03_GUI(String title) {
		super("GUI����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new BorderLayout());
		jp = new JPanel(new GridLayout(3, 2));  // �г��� �⺻���̾ƿ��� FlowLayout �̴�
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		jbtnOut = new JButton("ȭ�� ���", icon);
		jta = new JTextArea(5, 30);  // 5�� 30��¥��
		scroll = new JScrollPane(jta);
		friends = new ArrayList<Friend>();
		jp.add(new JLabel("�� ��", (int)CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("�� ȭ", (int)CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("�� ��", (int)CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		container.add(jp, BorderLayout.NORTH);
		container.add(jbtnOut, BorderLayout.CENTER);
		container.add(scroll, BorderLayout.SOUTH);
		jta.setText("�̸�\t��ȭ\t\t����\n");
		setVisible(true);
		setBounds(100, 100, 400, 300);
		
		
		jbtnOut.addActionListener(this);
		
		
		
	}
	
	public Ex03_GUI() {
		// TODO Auto-generated constructor stub
		this("");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnOut) { // name tel age �� friends (ArrayList)�� �߰�, jta�� ���.
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�");
				return;
			}
			if(/*tel.indexOf("-") == tel.lastIndexOf("-") || */tel.length() < 9) {
				System.out.println("��ȭ��ȣ�� �ٽ� �Է��ϼ���");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(jtxtAge.getText().trim());
				if(age < 0 || age >=120) {
					System.out.println("���̸� �ٽ� �Է��ϼ���");
					age = 0;
				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				System.out.println("���̸� �ٽ� �Է��ϼ���");
			}
			Friend friend = new Friend(name, tel, age);
			jta.append(friend.toString() + "\n");
			friends.add(friend);
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");
			System.out.println(friends.size() + "�� �ԷµǾ����ϴ�");
		}

	}

}