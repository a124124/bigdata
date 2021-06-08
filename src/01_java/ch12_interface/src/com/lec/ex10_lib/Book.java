package com.lec.ex10_lib;
//new Book();
public class Book implements ILendable{
	private String bookNo; // å ��ȣ.
	private String bookTitle;
	private String writter;
	private String borrower; //������ ���
	private String checkOutDate;
	private byte state; // 0 : ���� ����(STATE_NORMAL), 1 : ������STATE_BORROWED)
	
	
	
	public Book(String bookNo, String bookTitle, String writter) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writter = writter;
	}
// Book book1 = new Book("å��ȣ", "å����", "�۾���");
// book1.checkOut("����","210520");
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if(state != STATE_NORMAL) {
			System.out.println("�������� å�Դϴ�.");
			return;
					
		}
		// ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// ���� ó�� �� �޼���.
		System.out.println("\"" + bookTitle + "\" ������ ����Ǿ����ϴ�." );
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if (state != STATE_BORROWED) {
			System.out.println("�������� å�� �ƴմϴ�.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\" ������ �ݳ��Ǿ����ϴ�.");
		
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format("%s, %s �� ", bookTitle, writter);
//		result += state == STATE_BORROWED ? "������" : "���� ����";
		if(state == STATE_NORMAL) {
			result += " ���� ����";
		}else if(state == STATE_BORROWED) {
			result += " ������";
		}else {
			result += " �������� �����ϼ���";
		}
		return result;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	

}