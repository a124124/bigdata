package com.lec.ex11_account;

public class Account {

	private String accountNo;
	private String ownerName;
	private int balance;

	public Account() {
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(int money) {
		balance += money;
		System.out.printf("%s(%s) ??, %d ???? ?Ա? ?Ͽ????ϴ?.\n ?ܾ??? %d ?? ?Դϴ?.\n", ownerName, accountNo, money, balance);
	}

	public void withdraw(int money) {
		if (balance >= money) {
			balance -= money;
			System.out.printf("%s(%s) ??, %d ???? ???? ?Ͽ????ϴ?.\n ?ܾ??? %d ?? ?Դϴ?.\n", ownerName, accountNo, money, balance);
		} else {
			System.out.printf("%s(%s) ??, ?ܾ??? ?????մϴ?.\n ???? ?ܾ? : %d ??\n", ownerName, accountNo, balance);
		}
	}

//	public void printAccount() {
//		System.out.printf("%s(%s) ??, ?ܾ? : %d ??\n", ownerName, accountNo, balance);
//	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s(%s) ??, ?ܾ? : %d ??", ownerName, accountNo, balance);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
