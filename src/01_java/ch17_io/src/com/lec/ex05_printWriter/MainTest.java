package com.lec.ex05_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 1.  ��N(n)���� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, ����, �ּ�)�� ArrayList�� �޴´�
	(��, �Է��� ������ �����̸� ���� ���� �޽��� ����Ѵ�)
	2.  ArrayList������ �� ���� �����ߴ����� 
	customer.txt ���ϰ� �ܼ�â�� ����Ѵ�.

 */

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		OutputStream ops = null;
		PrintWriter printwriter = null;
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		String today = sdf.format(now);
		int cnt = 0;
		try {
			ops = new FileOutputStream("txtFile/customer.txt", true);
			printwriter = new PrintWriter(ops);
			while (true) {
				System.out.println("ȸ�������� �Ͻ÷��� �ƹ�Ű�� �Է��ϼ���(�����Ͻ÷��� n�� �Է��ϼ���)");
				String fn = sc.next();
				if (fn.equalsIgnoreCase("n")) {
					break;
				} else {
					cnt++;
					sc.nextLine();
					System.out.print("�̸�");
					customer.setName(sc.nextLine());
					System.out.print("��ȭ��ȣ");
					customer.setTel(sc.nextLine());
					System.out.print("����");
//					String birth = sc.nextLine();
					customer.setBirth(sc.nextLine());
					System.out.println("�ּ�");
					customer.setAddress(sc.nextLine());
					printwriter.println(customer.toString());
					if (customer.getBirth().equals(today)) {
						System.out.println(customer.getName() + "�� ������ �����մϴ�.");
					}
					customers.add(new Customer(customer.getName(), customer.getTel(), customer.getBirth(),
							customer.getAddress()));
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (printwriter != null)
					printwriter.close();
				if (ops != null)
					ops.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		System.out.println("����");
		sc.close();
		for (Customer e : customers) {
			System.out.println(e);
		}
		if (cnt == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println(cnt + "���� �����߽��ϴ�.");
		}

	}
}
