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
		super("GUI예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new BorderLayout());
		jp = new JPanel(new GridLayout(3, 2));  // 패널은 기본레이아웃이 FlowLayout 이다
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/output.png");
		jbtnOut = new JButton("화면 출력", icon);
		jta = new JTextArea(5, 30);  // 5행 30열짜리
		scroll = new JScrollPane(jta);
		friends = new ArrayList<Friend>();
		jp.add(new JLabel("이 름", (int)CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("전 화", (int)CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("나 이", (int)CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		container.add(jp, BorderLayout.NORTH);
		container.add(jbtnOut, BorderLayout.CENTER);
		container.add(scroll, BorderLayout.SOUTH);
		jta.setText("이름\t전화\t\t나이\n");
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
		if(e.getSource() == jbtnOut) { // name tel age 를 friends (ArrayList)에 추가, jta에 출력.
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다");
				return;
			}
			if(/*tel.indexOf("-") == tel.lastIndexOf("-") || */tel.length() < 9) {
				System.out.println("전화번호를 다시 입력하세요");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(jtxtAge.getText().trim());
				if(age < 0 || age >=120) {
					System.out.println("나이를 다시 입력하세요");
					age = 0;
				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				System.out.println("나이를 다시 입력하세요");
			}
			Friend friend = new Friend(name, tel, age);
			jta.append(friend.toString() + "\n");
			friends.add(friend);
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");
			System.out.println(friends.size() + "명 입력되었습니다");
		}

	}

}
