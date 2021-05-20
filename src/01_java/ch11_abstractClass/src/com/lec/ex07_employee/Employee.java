package com.lec.ex07_employee;

public abstract class Employee {
	private String name;
		
	
	public Employee(String name,int computePay) {
		this.name = name;
		
	}
	public abstract int computePay();
	
	public final int computeIncentive() {
		int pay = computePay();
		if(pay >= 3000000 ) {
			return (int)(pay * 0.05);
		}else {
			return 0;
		}
	}
	public String getName() {
		return name;

	
}
