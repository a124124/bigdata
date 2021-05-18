package com.lec.ex11_account;

public class CheckingAccount extends Account{
	private String cardNo;
	
	public CheckingAccount() {
		
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName); // super �� �ݵ�� ù��°�ܿ� �־����.
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance); // super �� �ݵ�� ù��°�ܿ� �־����.
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int money) {
		if(this.cardNo.equals(cardNo)) {
			if(getBalance() >= money) {
				setBalance(getBalance() - money);
				System.out.printf("�����Ǿ����ϴ�. %s(%s) ��, %d ���� ���� �Ͽ����ϴ�.\n �ܾ��� %d �� �Դϴ�.\n", getOwnerName(), getAccountNo(), money, getBalance());
			}else {
				System.out.printf("��������. %s(%s) ��, �ܾ��� %d �� �Դϴ�.\n", getOwnerName(), getAccountNo(), getBalance());
			}
		}else {
			System.out.println("�ùٸ� ī�� ��ȣ�� �Է��ϼ���.");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
}