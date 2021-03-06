package com.lec.ex01_person;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonManagerGUI extends JFrame implements ActionListener {
	// 화면에 추가될 컴포넌트

	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	// db 연동을 위한 변수
	private PersonDAO dao;
	private ArrayList<PersonDTO> person;

	public PersonManagerGUI(String title) {
		super(title);
		dao = PersonDAO.getInstance();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // 전체화면 get
		contenPane.setLayout(new FlowLayout()); // 전체화면의 레이아웃 세팅
		jpup = new JPanel(new GridLayout(5, 2));
		jpbtn = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("src/icon/join.png");
		btnInput = new JButton("입력", icon1);
		ImageIcon icon2 = new ImageIcon("src/icon/search.png");
		btnSearch = new JButton("직업조회", icon2);
		ImageIcon icon3 = new ImageIcon("src/icon/output.png");
		btnOutput = new JButton("전체출력", icon3);
		ImageIcon icon4 = new ImageIcon("src/icon/exit.png");
		btnExit = new JButton("종료", icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);

		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);

		setVisible(true);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnInput) {
			// txtname, comjob, txtkor, txteng, txtmat 값을 dao를 통해 insert
			String name = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(name.equals("") || jname.equals("") ||  korStr.equals("") || engStr.equals("") || matStr.equals("")) {
				txtPool.setText("모두 입력해야합니다");
				return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			int result = dao.insertPerson(new PersonDTO(name, jname, kor, eng, mat));
			if(result == PersonDAO.SUCCESS) {
				txtPool.setText(name + "님 입력 성공");
				txtName.setText("");
				comJob.setSelectedIndex(0);
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				
			}
			
		}else if(e.getSource() == btnSearch) {
			// comjob에 선택된 직업별 조회 결과를 txtpool 에 출력
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("직업 선택해주세요");
				return;
			}
			person = dao.selectJname(jname);
			if(person.isEmpty()) {
				txtPool.setText("해당 직업 사람 없음");
				
			}else {
				txtPool.setText("rank \t 이름 \t 직업 \t 국어\t 영어\t 수학\t 총점\n");
				for(PersonDTO p : person) {
					txtPool.append(p.toString() + "\n");
					
				}
			}
			
		}else if(e.getSource() == btnOutput) {
			// 전체 출력을 txtpool에			
			person = dao.selectAll();
			if(person.size() == 0) {
				txtPool.setText("회원이 없습니다");
				
			}else {
				txtPool.setText("rank \t 이름 \t 직업 \t 국어\t 영어\t 수학\t 총점\n");
				for(PersonDTO p : person) {
					txtPool.append(p.toString() + "\n");
					
				}
			}
		}else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new PersonManagerGUI("연예인 성적관리");
		
	}

}
