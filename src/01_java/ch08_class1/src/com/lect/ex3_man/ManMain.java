package com.lect.ex3_man;

public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(30, 178, 67, "010-9999-9999");
		Man kang = new Man(40, 166, 80);
		Man yi = new Man(183, 88);
		Man[] student = {kim, kang, yi};
		yi.setPhoneNum("010-7657-4444");
		student[1].setPhoneNum("010-6533-3653");
		student[2].setAge(36);
		
		double bmi = kim.calculaterBMI();
//		if (bmi > 24.5) {
//			System.out.println(kim.getPhoneNum() + " 님은 비만입니다.");
//		}else {
//			System.out.println(kim.getPhoneNum() + " 님은 다이어트 금지");
//		}
		for(int idx = 0; idx < student.length; idx++) {
			bmi = student[idx].calculaterBMI();
			if(bmi > 24.5) {
				System.out.println(student[idx].getPhoneNum() + " 님은 비만입니다");
			}else {
				System.out.println(student[idx].getPhoneNum() + " 님은 다이어트 금지");
			}
		}
	}
}
