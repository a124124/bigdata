package com.lec.ex07_employee;

public class SalaryEmployee extends Employee {
	public SalaryEmployee(String name, int computePay) {
		super(name, computePay);
		// TODO Auto-generated constructor stub
	}




	
	




	@Override
	public void computePay() {
		// TODO Auto-generated method stub
	
		System.out.println("= ���� ���� =");
		System.out.println("���� : " + getName());
		System.out.println("���� : " + getComputePay() / 14);
		System.out.println("�󿩱� : "  );
		
	}

	
}
