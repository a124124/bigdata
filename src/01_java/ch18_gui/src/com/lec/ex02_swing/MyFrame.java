package com.lec.ex02_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container container;
	private JPanel jp;
	private JTextField jtxtName;
	private JTextField jtxtTel;
	private JTextField jtxtAge;
	private JButton jbtnIn;
	private JButton jbtnOut;
	private ImageIcon icon;
	private ImageIcon icon2;
	private ArrayList<Person> persons;

	public MyFrame(String title) {
		// TODO Auto-generated constructor stub
		super("GUI 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new BorderLayout());
		jp = new JPanel(new GridLayout(3, 2));
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/join.png");
		icon2 = new ImageIcon("icon/output.png");
		persons = new ArrayList<Person>();
		jbtnIn = new JButton("입력", icon);
		jbtnOut = new JButton("출력", icon2);
		jp.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jp.add(jtxtName);
		jp.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jp.add(jtxtTel);
		jp.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jp.add(jtxtAge);
		container.add(jp, BorderLayout.NORTH);
		container.add(jbtnIn, BorderLayout.WEST);
		container.add(jbtnOut, BorderLayout.EAST);

		setVisible(true);
		setBounds(100, 100, 250, 150);

		jbtnIn.addActionListener(this);
		jbtnOut.addActionListener(this);

	}

	public MyFrame() {
		this("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbtnIn) { // name tel age 를 persons (arraylist) 에 추가, person.txt에 출력
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다");
				return;
			}

			int age = 0;
			try {
				age = Integer.parseInt(jtxtAge.getText().trim());
				if (age < 0 || age >= 120) {
					System.out.println("나이를 다시 입력하세요");
					age = 0;
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("나이를 입력 안하시면 0으로 출력됩니다");
			}
			Person person = new Person(name, tel, age);
			
			
				jtxtName.setText("");
				jtxtTel.setText("");
				jtxtAge.setText("");
				
				System.out.println((persons.size()+ 1) + "명 입력됨");
				persons.add(person);
			}
			if(e.getSource()==jbtnOut) {
				OutputStream ops = null;
				PrintWriter printwriter = null;
				try {
					ops = new FileOutputStream("icon/person.txt", true);
					printwriter = new PrintWriter(ops);
					System.out.printf("이름\t전화번호\t\t나이\n");
					printwriter.printf("이름\t전화번호\t\t나이\n");
					for (Person p : persons) {
						printwriter.println(p.toString());
						System.out.println(p);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				} finally {
					try {
						if (printwriter != null)
							printwriter.close();
						if (ops != null)
							ops.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					printwriter.println(persons.toString());
					System.out.println("출력과 저장 성공");
				}
				
			}

	
	

	}

	public static void main(String[] args) {
		new MyFrame();

	}
}
