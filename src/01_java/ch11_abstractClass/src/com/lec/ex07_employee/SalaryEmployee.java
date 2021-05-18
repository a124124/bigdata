package com.lec.ex07_employee;

public class SalaryEmployee extends Employee {
	public SalaryEmployee(String name, int computePay) {
		super(name, computePay);
		// TODO Auto-generated constructor stub
	}




	
	




	@Override
	public void computePay() {
		// TODO Auto-generated method stub
	
		System.out.println("= 월급 명세서 =");
		System.out.println("성함 : " + getName());
		System.out.println("월급 : " + getComputePay() / 14);
		System.out.println("상여금 : "  );
		
	}

	
}
