package com.lec.ex10_lib;

public interface ILendable {
	public byte STATE_BORROWED = 1;  //������
	public byte STATE_NORMAL = 0; //���Ⱑ��
	public void checkOut(String borrower, String checkOutDate); //����
	
	public void checkIn(); // �ݳ�
}
