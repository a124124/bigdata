package com.lect.ex4_bank;

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
			System.out.println("���¹�ȣ :" + accountNo + ", " + ownerName +"��");
			System.out.println(money + "�� �Ա� �Ϸ�. ������ :" + balance);
			System.out.println();
		}
		public int withdraw(int money) {
			if(money > balance) {
				System.out.println(money + "�� ��� �Ұ�");
				System.out.println("�ܾ��� �����մϴ�.");
				System.out.println();
			}else {
				balance = balance - money;
				System.out.println("���¹�ȣ :" + accountNo + ", " + ownerName +"��");
				System.out.println(money + "�� ��� �Ϸ�");
				System.out.println();
			}
			return balance;
		}
		public void info() {
			System.out.println("���¹�ȣ :" + accountNo + ", " + ownerName + "���� �ܾ� : " + balance);
			
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public String getOwnerName() {
			return ownerName;
		}
		
	
}
