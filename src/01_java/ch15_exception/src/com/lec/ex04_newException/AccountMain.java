package com.lec.ex04_newException;

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
		
		Account hong = new Account("110-1", "ȫ�浿", 50000);
		Account hong1 = new Account("110-2", "ȫ��");
		Account hong2 = new Account();
		hong2.setAccountNo("110-9");
		hong2.setOwnerName("�ű浿");
		hong2.deposit(40000);
		hong.deposit(10000);
		System.out.println(hong);
		try {
			hong.withdraw(4000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong1);
		hong2.deposit(10000);
		try {
			hong2.withdraw(20000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong2);

	}
	
	
}
