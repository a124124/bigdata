package com.lec.ex11_lib;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;

	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if (state != STATE_NORMAL) {
			System.out.println("대출중인 CD입니다.");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getCdTitle() + "CD가 대출 되었습니다.");
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if (state != STATE_BORROWED) {
			System.out.println("대출중인 CD이 아닙니다");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdNo() + "CD가 반납 되었습니다.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format(getCdTitle());
//		result += state == STATE_BORROWED ? "대출중" : "대출 가능";
		if (state == STATE_NORMAL) {
			result += " 대출 가능";
		} else if (state == STATE_BORROWED) {
			result += " 대출중";
		} else {
			result += " 직원에게 문의하세요";
		}
		return result;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}