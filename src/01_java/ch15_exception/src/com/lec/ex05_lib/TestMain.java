package com.lec.ex05_lib;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("890-01", "java", "김자바");
		BookLib book2 = new BookLib("890-02", "hadoop", "김하둡");
		BookLib book3 = new BookLib("890-03", "R", "김알");
		BookLib[] books = {book1, book2, book3};
		Scanner sc = new Scanner(System.in);
		int fn, i;
		String bTitle, borrower;
		
		
			do {
				System.out.print("1: 전체 대출여부 상태 열람 | 2: 대출 | 3: 반납 | 0: 종료");
				try {
					fn = sc.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("1,2,3,0 외의 문자를 입력하시면 종료됩니다");
					break;
				}
				switch(fn) {
				case 1: // 열람
					for(BookLib b : books) {
						System.out.println(b);
					}
					break;
				case 2: // 대출
					System.out.println("대출할 책 이름은?");
					sc.nextLine();
					bTitle = sc.nextLine();
					for(i = 0; i < books.length; i++) {
						if(bTitle.equalsIgnoreCase((books[i].getBookTitle()))) {
							break;
						}
					}
					if(i == books.length) {
						System.out.println("본 도서관에는 해당 도서가 없습니다.");
					}else {
						System.out.println("대출인은?");
						borrower = sc.next();
						try {
							books[i].checkOut(borrower);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					break;
				case 3: //반납
					System.out.println("반납할 책 이름은?");
					sc.nextLine();
					bTitle = sc.nextLine();
					for(i = 0; i < books.length; i++) {
						if(bTitle.equalsIgnoreCase(books[i].getBookTitle())) {
							break;
						}
					}
					if(i == books.length) {
						System.out.println("본 도서관에 없는 책입니다.");
				
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

