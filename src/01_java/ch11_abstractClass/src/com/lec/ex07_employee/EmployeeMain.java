package com.lec.ex07_employee;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee[] employees = {
				new SalaryEmployee("홍길동", 28000000),//정직원
				new SalaryEmployee("박직원", 70000000),//정직원
				new SalaryEmployee("윤사원", 24000000),//정직원
//				new HourlyEmployee("이알바", 100,8500),//아르바이트생
//				new HourlyEmployee("신알바", 120,9500)//아르바이트생
		};
		for(Employee i : employees) {
			i.computePay();
//			i.computeIncentive();
		}
	}
	
}
