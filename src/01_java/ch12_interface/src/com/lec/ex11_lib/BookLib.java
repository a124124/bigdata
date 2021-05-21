package com.lec.ex11_lib;

public class BookLib extends BookInfo implements ILendable{
	private String borrower;
	private String checkOutDate;
	private byte state; // 0 : ���� ����(STATE_NORMAL), 1 : ������STATE_BORROWED)
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if(state != STATE_NORMAL) {
			System.out.println("�������� å�Դϴ�.");
			return;
		}
		
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "������ ���� �Ǿ����ϴ�.");
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			System.out.println("�������� å�� �ƴմϴ�");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "������ �ݳ� �Ǿ����ϴ�.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format("%s, %s ", getBookTitle(), getWriter());
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
