package com.lec.ex11_lib;

public class BookLib extends BookInfo implements ILendable{
	private String borrower;
	private String checkOutDate;
	private byte state; // 0 : 대출 가능(STATE_NORMAL), 1 : 대출중STATE_BORROWED)
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if(state != STATE_NORMAL) {
			System.out.println("대출중인 책입니다.");
			return;
		}
		
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle() + "도서가 대출 되었습니다.");
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if(state != STATE_BORROWED) {
			System.out.println("대출중인 책이 아닙니다");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "도서가 반납 되었습니다.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format("%s, %s ", getBookTitle(), getWriter());
//		result += state == STATE_BORROWED ? "대출중" : "대출 가능";
		if(state == STATE_NORMAL) {
			result += " 대출 가능";
		}else if(state == STATE_BORROWED) {
			result += " 대출중";
		}else {
			result += " 직원에게 문의하세요";
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
