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
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMnameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpel = new JButton("����ó��");
		btnExpelOut = new JButton("���������");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scr = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int)CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(comMnames);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
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
	// 1. �й� �˻�	
		if(e.getSource() == btnSNoSearch) {
			String sNo = txtSNo.getSelectedText().toString();
			
						
			student = dao.selectSearchSNo(sNo);
			if(student.isEmpty()) {
				txtPool.setText("�ش� �й� �л� ����");
			}else {
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
//////////////////////////////////////////////////////////////////////////
	// 2. �̸� �˻�
		}else if(e.getSource() == btnSNameSearch) {
			
			
//////////////////////////////////////////////////////////////////////////
	// 3. ���� �˻�			
		}else if(e.getSource() == btnMnameSearch) {
			String mname = comMnames.getSelectedItem().toString();
			if(mname.equals("")) {
				txtPool.setText("������ �������ּ���");
				return;
			}
			student = dao.selectSearchMName(mname);
			if(mname.isEmpty()) {
				System.out.println("�ش� �а� ��� ����");
				
			}else {
				txtPool.setText("rank\t �̸�(�й�) \t ������(������ȣ) \t ���� ");
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
			
//////////////////////////////////////////////////////////////////////////
	// 4. �л� �Է�
		}else if(e.getSource() == btnInput) {
			
			
			
			
//////////////////////////////////////////////////////////////////////////
	// 5. �л� ����
		}else if(e.getSource() == btnUpdate) {
			
			
			
			
//////////////////////////////////////////////////////////////////////////
	// 6. �л� ���				
		}else if(e.getSource() == btnStudentOut) {
			student = dao.selectAll();
			if(student.size() == 0) {
				txtPool.setText("�л��� �����ϴ�");
			}else {
				for(StudentDTO s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
			
			
//////////////////////////////////////////////////////////////////////////
	// 7. ������ ���
		}else if(e.getSource() == btnExpelOut) {
			
			
			
//////////////////////////////////////////////////////////////////////////
	//8. ���� ó��		
		}else if(e.getSource() == btnExpel) {
		
			
//////////////////////////////////////////////////////////////////////////
	// 9. ����		
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new StudentGUI("�л����");
	
	}
	

}