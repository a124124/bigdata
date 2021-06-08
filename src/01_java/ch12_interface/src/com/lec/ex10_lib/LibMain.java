package com.lec.ex10_lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {

		Book[] books = { new Book("001", "�ڹ�", "�ڱ浿"), new Book("002", "����Ŭ", "���浿"), new Book("003", "���̽�", "�ı浿"),
				new Book("004", "��", "���浿"), new Book("005", "�ϵ�", "�ϱ浿") };
		Scanner scanner = new Scanner(System.in);
		int fn, idx = 0; // 1.����, 2.�ݳ�, 3.1������Ȳ, 0.����
		String bTitle, borrower, checkOutDate; // ������ ���ϴ� å�̸�, ������, ������
		do {
			System.out.println("1. ���� | 2. �ݳ� | 3. ������Ȳ | 0. ����");
			fn = scanner.nextInt();
			switch (fn) {
			case 1: // 1 å�̸� �Է� > 2 å��ȸ > 3 å���� Ȯ�� > 4 ������, ������ > 5 ����
				System.out.println("������ å�̸���?");
				bTitle = scanner.next(); // next �� String �� �޴´�.

				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("�� ���������� �ش� ������ �����ϴ�.");

				} else if (books[idx].getState() == Book.STATE_BORROWED) { // ������ idx ��°�� ������
					System.out.println(bTitle + "������ ���� ���Դϴ�.");
				} else {
					// ������, ������ �Է�
					System.out.print("������ �Է��ϼ���.\n");
					borrower = scanner.next();
					System.out.println("���� ��¥�� �Է��ϼ���");
					checkOutDate = scanner.next();
					// ����
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2:
				// ()1 å�� �츮 �������� �ִ� å���� Ȯ���ϴ� ���� �Ŀ� (2) �ݳ�ó��
				System.out.println("�ݳ��� å�̸���?");
				bTitle = scanner.next(); // next �� String �� �޴´�.
				// å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				} else { // �ݳ�
					books[idx].checkIn();
				}

				break;
			case 3:
				for (Book book : books) {
					System.out.println(book);
				}
				break;
			case 4: //cd ����
				
			default:
				System.out.println("���ڸ� �ٽ� �Է��ϼ���");

			}
		} while (fn != 0);
		System.out.println("�ȳ��� ������");
		scanner.close();
	}
}