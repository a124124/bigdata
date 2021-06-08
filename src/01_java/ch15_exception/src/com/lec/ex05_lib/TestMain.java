package com.lec.ex05_lib;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("890-01", "java", "���ڹ�");
		BookLib book2 = new BookLib("890-02", "hadoop", "���ϵ�");
		BookLib book3 = new BookLib("890-03", "R", "���");
		BookLib[] books = {book1, book2, book3};
		Scanner sc = new Scanner(System.in);
		int fn, i;
		String bTitle, borrower;
		
		
			do {
				System.out.print("1: ��ü ���⿩�� ���� ���� | 2: ���� | 3: �ݳ� | 0: ����");
				try {
					fn = sc.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("1,2,3,0 ���� ���ڸ� �Է��Ͻø� ����˴ϴ�");
					break;
				}
				switch(fn) {
				case 1: // ����
					for(BookLib b : books) {
						System.out.println(b);
					}
					break;
				case 2: // ����
					System.out.println("������ å �̸���?");
					sc.nextLine();
					bTitle = sc.nextLine();
					for(i = 0; i < books.length; i++) {
						if(bTitle.equalsIgnoreCase((books[i].getBookTitle()))) {
							break;
						}
					}
					if(i == books.length) {
						System.out.println("�� ���������� �ش� ������ �����ϴ�.");
					}else {
						System.out.println("��������?");
						borrower = sc.next();
						try {
							books[i].checkOut(borrower);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					break;
				case 3: //�ݳ�
					System.out.println("�ݳ��� å �̸���?");
					sc.nextLine();
					bTitle = sc.nextLine();
					for(i = 0; i < books.length; i++) {
						if(bTitle.equalsIgnoreCase(books[i].getBookTitle())) {
							break;
						}
					}
					if(i == books.length) {
						System.out.println("�� �������� ���� å�Դϴ�.");
				
					}else {
						try {
							books[i].checkIn();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
					
				}
				
			}while(fn == 0 || fn == 1 || fn ==2);
			sc.close();
		
	
//		try {
//			book1.checkOut("kim");
//			book2.checkOut("lee");
//			book1.setCheckOutDate(new Date(new GregorianCalendar(2021, 2, 3).getTimeInMillis()));
//			book1.checkIn();
//			
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			System.out.println(book1);
//			System.out.println(book2);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	}
}
