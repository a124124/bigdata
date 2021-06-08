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
	SimpleDateFormat sdf = new SimpleDateFormat("(yy-MM-dd E����)");
	
	
	
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
			throw new Exception("�̹� �������� å�Դϴ�");
//			System.out.println("�̹� �������� å�Դϴ�.");
			
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.printf("\"%s \"��(��) �ڴ���ڵǾ����ϴ�.\n", bookTitle);
		System.out.printf("[������] %s\n", borrower);
//		System.out.printf("[������] %1$tY�� %1$tm�� %1$td��(%1$t)\n", date);
		System.out.println("[������] " + sdf.format(checkOutDate));
		
	}

	@Override
	public void checkIn() throws Exception{
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			throw new Exception(bookTitle + "�������� å�� �ƴմϴ�.");
//			System.out.println("�������� å�� �ƴմϴ�.");

		}
		long diff = checkInDate.getTime() - checkOutDate.getTime();
		long day = diff / (1000 * 60 * 60 * 24);
		System.out.println("���� �Ⱓ : " + day + " ��");
		Scanner sc = new Scanner(System.in);
		if(day > 14) {
			int money = ((int)day - 14) * 100;
			System.out.printf("��ü�� 1�� 100�� �ΰ��մϴ�.\n���ž� �� ��ü��� %d��\n", money);
			System.out.println("��ü�Ḧ ���̳���? (Y/N)");
			if(!sc.next().equalsIgnoreCase("Y")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �˴ϴ�.");
				state = STATE_BORROWED;
				return;
			}
		}

		this.borrower = null;
		checkInDate = new Date();
		state = STATE_NORMAL;
		checkOutDate = null;
		System.out.println("\"" + bookTitle + "\" ������ �ݳ��Ǿ����ϴ�.");
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			return String.format("\"%s\" %s��  ���Ⱑ��", bookTitle, writer);
		}else {
			return "\"" + bookTitle + "\""  + writer + "��  ����" + sdf.format(checkOutDate) + "��";
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