package com.lec.ex11_lib;

public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkOut(String borrower, String checkOutDate);
	
	public void checkIn();
	@Override
	String toString();
	
}
