package com.lec.ex10_lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {

		Book[] books = { new Book("001", "자바", "자길동"), new Book("002", "오라클", "오길동"), new Book("003", "파이썬", "파길동"),
				new Book("004", "웹", "웹길동"), new Book("005", "하둡", "하길동") };
		Scanner scanner = new Scanner(System.in);
		int fn, idx = 0; // 1.대출, 2.반납, 3.1도서현황, 0.종료
		String bTitle, borrower, checkOutDate; // 대출을 원하는 책이름, 대출인, 대출일
		do {
			System.out.println("1. 대출 | 2. 반납 | 3. 도서현황 | 0. 종료");
			fn = scanner.nextInt();
			switch (fn) {
			case 1: // 1 책이름 입력 > 2 책조회 > 3 책상태 확인 > 4 대출인, 대출일 > 5 대출
				System.out.println("대출할 책이름은?");
				bTitle = scanner.next(); // next 는 String 을 받는다.

				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("본 도서관에는 해당 도서가 없습니다.");

				} else if (books[idx].getState() == Book.STATE_BORROWED) { // 도서가 idx 번째에 있을때
					System.out.println(bTitle + "도서는 대출 중입니다.");
				} else {
					// 대출인, 대출일 입력
					System.out.print("성함을 입력하세요.\n");
					borrower = scanner.next();
					System.out.println("오늘 날짜를 입력하세요");
					checkOutDate = scanner.next();
					// 대출
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2:
				// ()1 책이 우리 도서관에 있는 책인지 확인하는 절차 후에 (2) 반납처리
				System.out.println("반납할 책이름은?");
				bTitle = scanner.next(); // next 는 String 을 받는다.
				// 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				} else { // 반납
					books[idx].checkIn();
				}

				break;
			case 3:
				for (Book book : books) {
					System.out.println(book);
				}
				break;
			case 4: //cd 대출
				
			default:
				System.out.println("숫자를 다시 입력하세요");

			}
		} while (fn != 0);
		System.out.println("안녕히 가세요");
		scanner.close();
	}
}
