package com.lec.ex02_customer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {

	private Container contanPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scr;
	
	private CustomerDAO dao;
	private ArrayList<CustomerDTO> dto;

	
	public CustomerMng(String title) {
		super(title);
		dao = CustomerDAO.getInstance();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanPane = getContentPane();
		contanPane.setLayout(new GridLayout(3, 2));
		jpup = new JPanel();
		jpup.setLayout(new FlowLayout());
		jpdown = new JPanel();
		jpdown.setLayout(new FlowLayout());
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		jta = new JTextArea(15, 30);
		scr = new JScrollPane(jta);
		btnInput = new JButton("가입");
		btnSearch = new JButton("번호");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		
		jpup.add(new JLabel("번호", (int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		
		jpdown.add(btnInput);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		contanPane.add(jpup);
		contanPane.add(jpdown);
		contanPane.add(scr);
		
		
		setBounds(300, 300, 400, 450);
		setResizable(false);
		setVisible(true);
		// 이벤트 리스너 추가
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
	}
	
	public CustomerMng() {
		this("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInput) {	// 가입
			String phone, name; int point=1000;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			try {
				point = Integer.parseInt(txtPhone.getText().trim());
			}catch (Exception e1) { }
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");
			if(!phone.equals("") && !name.equals("") &&
					preIdx<postIdx) { // 전화번호는 xxx-xx-xx타입으로, 이름은 반드시 입력 
				//가입
				CustomerDTO newCustomer = new CustomerDTO(0, phone, name, point);
				int result = dao.insertCustomer(newCustomer);
				jta.setText(result==CustomerDAO.SUCCESS? name+"님 가입성공":"가입실패");
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("1000");
			}else {
				jta.setText("유효한 값을 입력하세요");
			}
		}else if(e.getSource() == btnSearch) {
			// 동명일인이면 textField에 뿌리고, 동명이인이면 jta에 뿌리고, 없는 번호면 없는 번호라고 뿌리기
			String searchPhone = txtPhone.getText().trim();
			if(searchPhone.equals("")) {
				jta.setText("조회하고자 하는 전화번호 뒷자리나 전화번호 전체를 입력하세요");
				return;
			}
			dto = dao.selectSearchPhone(searchPhone);
			if(dto.size()==1) {
				String phone = dto.get(0).getPhone();
				String name  = dto.get(0).getName();
				int    point = dto.get(0).getPoint();
				txtPhone.setText(phone);
				txtName.setText(name);
				txtPoint.setText(String.valueOf(point));//int를 문자열로 바꿔서 setText함
			}else if(dto.size()>1) {
				for(CustomerDTO customer : dto) {
					jta.append(customer.toString()+"\n");
				}
			}else {
				txtName.setText("검색되지 않는 전화번호입니다");
			}
		}else if(e.getSource() == btnOutput) {
			dto = dao.selectAll();
			if(dto.size()==0) {
				jta.append("회원이 없습니다");
			}else {
				for(CustomerDTO customer : dto) {
					jta.append(customer.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}//if
	}
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}