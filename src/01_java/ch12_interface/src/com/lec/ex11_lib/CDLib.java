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
			System.out.println("�������� CD�Դϴ�.");
			return;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getCdTitle() + "CD�� ���� �Ǿ����ϴ�.");
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if (state != STATE_BORROWED) {
			System.out.println("�������� CD�� �ƴմϴ�");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdNo() + "CD�� �ݳ� �Ǿ����ϴ�.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format(getCdTitle());
//		result += state == STATE_BORROWED ? "������" : "���� ����";
		if (state == STATE_NORMAL) {
			result += " ���� ����";
		} else if (state == STATE_BORROWED) {
			result += " ������";
		} else {
			result += " �������� �����ϼ���";
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