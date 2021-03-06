package com.lec.ex10_lib;
//new Book();
public class Book implements ILendable{
	private String bookNo; // 책 번호.
	private String bookTitle;
	private String writter;
	private String borrower; //대출한 사람
	private String checkOutDate;
	private byte state; // 0 : 대출 가능(STATE_NORMAL), 1 : 대출중STATE_BORROWED)
	
	
	
	public Book(String bookNo, String bookTitle, String writter) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writter = writter;
	}
// Book book1 = new Book("책번호", "책제목", "글쓴이");
// book1.checkOut("김길순","210520");
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if(state != STATE_NORMAL) {
			System.out.println("대출중인 책입니다.");
			return;
					
		}
		// 대출처리 로직
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// 대출 처리 후 메세지.
		System.out.println("\"" + bookTitle + "\" 도서가 대출되었습니다." );
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if (state != STATE_BORROWED) {
			System.out.println("대출중인 책이 아닙니다.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\" 도서가 반납되었습니다.");
		
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format("%s, %s 저 ", bookTitle, writter);
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
