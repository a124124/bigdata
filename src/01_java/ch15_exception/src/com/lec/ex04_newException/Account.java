package com.lec.ex04_newException;

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
			System.out.println("???¹?ȣ :" + accountNo + ", " + ownerName +"??");
			System.out.println(money + "?? ?Ա? ?Ϸ?. ?????? :" + balance);
			System.out.println();
		}
		public int withdraw(int money) throws Exception{
			if(money > balance) {
				throw new Exception(money + "?? ???? ?Ұ?. ?ܾ? : " + balance);
			}else {
				balance = balance - money;
				System.out.println("???¹?ȣ :" + accountNo + ", " + ownerName +"??");
				System.out.println(money + "?? ???? ?Ϸ?");
				System.out.println();
			}
			return balance;
		}
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return 	"???¹?ȣ :" + accountNo + ", " + ownerName + "???? ?ܾ? : " + balance;
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
