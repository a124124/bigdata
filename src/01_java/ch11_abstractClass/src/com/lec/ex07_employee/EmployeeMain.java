package com.lec.ex07_employee;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee[] employees = {
				new SalaryEmployee("ȫ�浿", 28000000),//������
				new SalaryEmployee("������", 70000000),//������
				new SalaryEmployee("�����", 24000000),//������
//				new HourlyEmployee("�̾˹�", 100,8500),//�Ƹ�����Ʈ��
//				new HourlyEmployee("�ž˹�", 120,9500)//�Ƹ�����Ʈ��
		};
		for(Employee i : employees) {
			i.computePay();
//			i.computeIncentive();
		}
	}
	
}