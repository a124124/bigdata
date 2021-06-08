package com.lec.ex02_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {
	private JPanel jpanel; // �����̳ʸ� ������ ���� ����.
	private ImageIcon icon;
	private JButton jbtn;
	private JTextField jtxtField;
	private String[] item = { "A", "B", "C" };
	private Vector<String> items;
	private JComboBox<String> jCombo;
	private JCheckBox jcheck;
	private JLabel jlBlank;
	private JButton jbtnExit;

	public Ex02() {
		// TODO Auto-generated constructor stub
		// add -> ũ��, ��ġ ����

		setDefaultCloseOperation(EXIT_ON_CLOSE); // X Ŭ���� ����.
		jpanel = (JPanel) getContentPane();
		jpanel.setLayout(new FlowLayout()); // ���̾ƿ� ����
		icon = new ImageIcon("icon/write.gif");
		jbtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		jCombo = new JComboBox<String>(item); // �޺��ڽ� ����Ʈ�� item �迭�� ���
		items = new Vector<String>();
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items);

		jcheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel();
		jbtnExit = new JButton("Exit");

		jpanel.add(new JLabel("Label"));
		jpanel.add(jbtn);
		jpanel.add(jtxtField);
		jpanel.add(jCombo);
		jpanel.add(jcheck);
		jpanel.add(jlBlank);
		jpanel.add(jbtnExit);

		jbtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jcheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 100));
		jbtnExit.setPreferredSize(new Dimension(100, 50));
		pack();
		setVisible(true);
		setLocation(200, 200);
		jbtn.addActionListener(this);
		jCombo.addActionListener(this);
		jcheck.addActionListener(this);
		jbtnExit.addActionListener(this);

	}

	public Ex02(String title) {
		this();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbtn) {
			String temp = jtxtField.getText().trim().toUpperCase();

			if (temp.equals("")) {
				return; // �� String �� ������ �׳� ������.
			}
			items.add(temp);
			jlBlank.setText(jtxtField.getText().trim());
			jtxtField.setText("");
			String name = JOptionPane.showInputDialog("�̸���?");
			System.out.println(name + "�� �ݰ����ϴ�");

		} else if (e.getSource() == jCombo) {
			jlBlank.setText(jCombo.getSelectedItem().toString());
			jCombo.setSelectedIndex(0);

		} else if (e.getSource() == jcheck) {
			if(jcheck.isSelected()) { // üũ��
				jlBlank.setText(jcheck.getText());
			}else { // üũ������
				jlBlank.setText("");
			}

		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

}