package com.lec.ex11_account;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-111", "ȫ?浿", 4000);
		CheckingAccount a2 = new CheckingAccount("222-222", "??????", 2000, "1111-2222-3333-4444");
		
		CreditLineAccount a3 = new CreditLineAccount("333-444", "??????", 45000, "2222-3333-4444-5555", 10000);
		
		
		a1.deposit(8900);
		a1.withdraw(30000);
		a2.withdraw(500);
		a2.pay("1111-2222-3333-4443", 1000);
		a2.pay("1111-2222-3333-4444", 1000);
		a3.pay("2222-3333-4444-5556", 15000);
		a3.pay("2222-3333-4444-5555", 15000);
		a3.pay("2222-3333-4444-5555", 8000);
	}
}
