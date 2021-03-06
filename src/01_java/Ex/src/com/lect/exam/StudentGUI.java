package com.lect.exam;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGUI extends JFrame implements ActionListener {
	private Container contanpane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames;
	private JComboBox<String> comMnames;
	private JButton btnSNoSearch, btnSNameSearch, btnMnameSearch,
			btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scr;
	
	
	private StudentDAO dao;
	private ArrayList<StudentDTO> student;
	
	public StudentGUI(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		dao = StudentDAO.getInstance();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanpane = getContentPane();
		contanpane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = dao.majorList();
		comMnames = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMnameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpel = new JButton("제적처리");
		btnExpelOut = new JButton("제적자출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scr = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int)CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int)CENTER_ALIGNMENT));
		jpup.add(comMnames);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("점수", (int)CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		
		
//		btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExit);
		
		
		contanpane.add(jpup);
		contanpane.add(jpbtn);
		contanpane.add(scr);
		
		setVisible(true);
		setSize(new Dimension(600, 400));
		setLocation(300, 300);
		
//	 btnSNoSearch, btnSNameSearch, btnMnameSearch,
//		btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
		
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//////////////////////////////////////////////////////////////////////////
	// 1. 학번 검색	
		if(e.getSource() == btnSNoSearch) {
			String sNo = txtSNo.getSelectedText().toString();
			
						
			student = dao.selectSearchSNo(sNo);
			if(student.isEmpty()) {
				txtPool.setText("해당 학번 학생 없음");
			}else {
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
//////////////////////////////////////////////////////////////////////////
	// 2. 이름 검색
		}else if(e.getSource() == btnSNameSearch) {
			
			
//////////////////////////////////////////////////////////////////////////
	// 3. 전공 검색			
		}else if(e.getSource() == btnMnameSearch) {
			String mname = comMnames.getSelectedItem().toString();
			if(mname.equals("")) {
				txtPool.setText("전공을 선택해주세요");
				return;
			}
			student = dao.selectSearchMName(mname);
			if(mname.isEmpty()) {
				System.out.println("해당 학과 사람 없음");
				
			}else {
				txtPool.setText("rank\t 이름(학번) \t 전공명(전공번호) \t 점수 ");
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
			
//////////////////////////////////////////////////////////////////////////
	// 4. 학생 입력
		}else if(e.getSource() == btnInput) {
			
			
			
			
//////////////////////////////////////////////////////////////////////////
	// 5. 학생 수정
		}else if(e.getSource() == btnUpdate) {
			
			
			
			
//////////////////////////////////////////////////////////////////////////
	// 6. 학생 출력				
		}else if(e.getSource() == btnStudentOut) {
			student = dao.selectAll();
			if(student.size() == 0) {
				txtPool.setText("학생이 없습니다");
			}else {
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
			
			
//////////////////////////////////////////////////////////////////////////
	// 7. 제적자 출력
		}else if(e.getSource() == btnExpelOut) {
			
			
			
//////////////////////////////////////////////////////////////////////////
	//8. 제적 처리		
		}else if(e.getSource() == btnExpel) {
		
			
//////////////////////////////////////////////////////////////////////////
	// 9. 종료		
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new StudentGUI("학사관리");
	
	}
	

}
