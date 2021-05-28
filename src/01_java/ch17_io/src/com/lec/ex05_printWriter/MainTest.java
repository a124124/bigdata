package com.lec.ex05_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 1.  “N(n)”을 입력할 때까지 회원가입 정보(이름, 전화번호, 생일, 주소)를 ArrayList에 받는다
	(단, 입력한 생일이 오늘이면 생일 축하 메시지 출력한다)
	2.  ArrayList정보와 몇 명이 가입했는지를 
	customer.txt 파일과 콘솔창에 출력한다.

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
				System.out.println("회원가입을 하시려면 아무키를 입력하세요(종료하시려면 n을 입력하세요)");
				String fn = sc.next();
				if (fn.equalsIgnoreCase("n")) {
					break;
				} else {
					cnt++;
					sc.nextLine();
					System.out.print("이름");
					customer.setName(sc.nextLine());
					System.out.print("전화번호");
					customer.setTel(sc.nextLine());
					System.out.print("생일");
//					String birth = sc.nextLine();
					customer.setBirth(sc.nextLine());
					System.out.println("주소");
					customer.setAddress(sc.nextLine());
					printwriter.println(customer.toString());
					if (customer.getBirth().equals(today)) {
						System.out.println(customer.getName() + "님 생일을 축하합니다.");
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
		System.out.println("종료");
		sc.close();
		for (Customer e : customers) {
			System.out.println(e);
		}
		if (cnt == 0) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println(cnt + "명이 가입했습니다.");
		}

	}
}
