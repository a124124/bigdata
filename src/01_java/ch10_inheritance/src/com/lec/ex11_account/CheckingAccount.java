package com.lec.ex11_account;

public class CheckingAccount extends Account{
	private String cardNo;
	
	public CheckingAccount() {
		
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName); // super 는 반드시 첫번째단에 넣어야함.
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance); // super 는 반드시 첫번째단에 넣어야함.
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int money) {
		if(this.cardNo.equals(cardNo)) {
			if(getBalance() >= money) {
				setBalance(getBalance() - money);
				System.out.printf("결제되었습니다. %s(%s) 님, %d 원을 결제 하였습니다.\n 잔액은 %d 원 입니다.\n", getOwnerName(), getAccountNo(), money, getBalance());
			}else {
				System.out.printf("결제실패. %s(%s) 님, 잔액은 %d 원 입니다.\n", getOwnerName(), getAccountNo(), getBalance());
			}
		}else {
			System.out.println("올바른 카드 번호를 입력하세요.");
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
}
