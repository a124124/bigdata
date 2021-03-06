package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILenderble{

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date date = new Date();
	private Date checkOutDate;
	private Date checkInDate;
	private byte state;
	SimpleDateFormat sdf = new SimpleDateFormat("(yy-MM-dd E요일)");
	
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower) throws Exception{
		// TODO Auto-generated method stub
		if(state != STATE_NORMAL) {
			throw new Exception("이미 대출중인 책입니다");
//			System.out.println("이미 대출중인 책입니다.");
			
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.printf("\"%s \"이(가) ★대출★되었습니다.\n", bookTitle);
		System.out.printf("[대출인] %s\n", borrower);
//		System.out.printf("[대출일] %1$tY년 %1$tm월 %1$td일(%1$t)\n", date);
		System.out.println("[대출일] " + sdf.format(checkOutDate));
		
	}

	@Override
	public void checkIn() throws Exception{
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			throw new Exception(bookTitle + "대출중인 책이 아닙니다.");
//			System.out.println("대출중인 책이 아닙니다.");

		}
		long diff = checkInDate.getTime() - checkOutDate.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		System.out.println("대출 기간 : " + day + " 일");
		Scanner sc = new Scanner(System.in);
		if(day > 14) {
			int money = ((int)day - 14) * 100;
			System.out.printf("연체료 1일 100원 부가합니다.\n내셔야 할 연체료는 %d원\n", money);
			System.out.println("연체료를 내셨나요? (Y/N)");
			if(!sc.next().equalsIgnoreCase("Y")) {
				System.out.println("연체료를 내셔야 반납처리가 됩니다.");
				state = STATE_BORROWED;
				return;
			}
		}

		this.borrower = null;
		checkInDate = new Date();
		state = STATE_NORMAL;
		checkOutDate = null;
		System.out.println("\"" + bookTitle + "\" 도서가 반납되었습니다.");
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			return String.format("\"%s\" %s著  대출가능", bookTitle, writer);
		}else {
			return "\"" + bookTitle + "\""  + writer + "著  대출" + sdf.format(checkOutDate) + "중";
		}
		 
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public Date getDate() {
		return date;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public byte getState() {
		return state;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public void setState(byte state) {
		this.state = state;
	}


}
