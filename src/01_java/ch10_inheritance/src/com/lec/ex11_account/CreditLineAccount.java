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
		if (getCardNo().equals(cardNo)) {// 올바른 카드 번호 입력
			if (creditLine >= money) {
				creditLine -= money;
				System.out.printf("%s 님 결제 완료. 남은 한도 : %d 원\n", getOwnerName(), creditLine);
			} else {
				System.out.printf("%s 님 결제 실패. 결제 한도 초과입니다.\n", getOwnerName());
			}
		} else {
			System.out.println("카드 번호가 맞지 않습니다.");
		}
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

}
