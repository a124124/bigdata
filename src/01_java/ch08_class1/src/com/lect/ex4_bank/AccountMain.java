package com.lect.ex4_bank;

public class AccountMain {
	public static void main(String[] args) {
//		Account ppl1 = new Account();
//		Account ppl2 = new Account("1","��");
//		ppl1.deposit(4000);
//		ppl1.setOwnerName("ȫ");
//		ppl1.setAccountNo("100-100");
//		ppl2.setAccountNo("100-101");
//		ppl2.deposit(5000000);
//		ppl2.withdraw(2800000);
//		ppl1.info();
//		ppl2.info();
		
		Account hong = new Account("110-1", "ȫ�浿", 10000);
		Account hong1 = new Account("110-2", "ȫ��");
		Account hong2 = new Account();
		hong2.setAccountNo("110-9");
		hong2.setOwnerName("�ű浿");
		hong.deposit(10000);
		hong.info();
		hong1.withdraw(1);
		hong1.info();
		hong2.deposit(10000);
		hong2.withdraw(2000);
		hong2.info();

	}
	
	
}
