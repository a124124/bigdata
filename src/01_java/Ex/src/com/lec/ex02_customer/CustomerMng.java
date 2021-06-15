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
		btnInput = new JButton("����");
		btnSearch = new JButton("��ȣ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
		
		jpup.add(new JLabel("��ȣ", (int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ", (int)CENTER_ALIGNMENT));
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
		// �̺�Ʈ ������ �߰�
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
		if(e.getSource() == btnInput) {	// ����
			String phone, name; int point=1000;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			try {
				point = Integer.parseInt(txtPhone.getText().trim());
			}catch (Exception e1) { }
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");
			if(!phone.equals("") && !name.equals("") &&
					preIdx<postIdx) { // ��ȭ��ȣ�� xxx-xx-xxŸ������, �̸��� �ݵ�� �Է� 
				//����
				CustomerDTO newCustomer = new CustomerDTO(0, phone, name, point);
				int result = dao.insertCustomer(newCustomer);
				jta.setText(result==CustomerDAO.SUCCESS? name+"�� ���Լ���":"���Խ���");
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("1000");
			}else {
				jta.setText("��ȿ�� ���� �Է��ϼ���");
			}
		}else if(e.getSource() == btnSearch) {
			// ���������̸� textField�� �Ѹ���, ���������̸� jta�� �Ѹ���, ���� ��ȣ�� ���� ��ȣ��� �Ѹ���
			String searchPhone = txtPhone.getText().trim();
			if(searchPhone.equals("")) {
				jta.setText("��ȸ�ϰ��� �ϴ� ��ȭ��ȣ ���ڸ��� ��ȭ��ȣ ��ü�� �Է��ϼ���");
				return;
			}
			dto = dao.selectSearchPhone(searchPhone);
			if(dto.size()==1) {
				String phone = dto.get(0).getPhone();
				String name  = dto.get(0).getName();
				int    point = dto.get(0).getPoint();
				txtPhone.setText(phone);
				txtName.setText(name);
				txtPoint.setText(String.valueOf(point));//int�� ���ڿ��� �ٲ㼭 setText��
			}else if(dto.size()>1) {
				for(CustomerDTO customer : dto) {
					jta.append(customer.toString()+"\n");
				}
			}else {
				txtName.setText("�˻����� �ʴ� ��ȭ��ȣ�Դϴ�");
			}
		}else if(e.getSource() == btnOutput) {
			dto = dao.selectAll();
			if(dto.size()==0) {
				jta.append("ȸ���� �����ϴ�");
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
		new CustomerMng("ȸ������");
	}
}