package com.lec.ex11_account;

public class CreditLineAccount extends CheckingAccount {

	private int creditLine;
	


	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, int money, String cardNo, int creditLine) {
		super(accountNo, ownerName, money, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNo, int money) {
		if (getCardNo().equals(cardNo)) {// �ùٸ� ī�� ��ȣ �Է�
			if (creditLine >= money) {
				creditLine -= money;
				System.out.printf("%s �� ���� �Ϸ�. ���� �ѵ� : %d ��\n", getOwnerName(), creditLine);
			} else {
				System.out.printf("%s �� ���� ����. ���� �ѵ� �ʰ��Դϴ�.\n", getOwnerName());
			}
		} else {
			System.out.println("ī�� ��ȣ�� ���� �ʽ��ϴ�.");
		}
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

}