package com.lec.ex07_employee;

public class HourlyEmployee extends Employee{
	
	
	private int hoursWorked;
	private int moneyPerHour;
	
	public HourlyEmployee(String name, int computePay) {
		super(name, computePay);
		computePay = hoursWorked * moneyPerHour;
		// TODO Auto-generated constructor stub
	}




	@Override
	public void computePay() {
		// TODO Auto-generated method stub
		
	}



}
