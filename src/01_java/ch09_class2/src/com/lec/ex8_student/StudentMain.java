package com.lec.ex8_student;

public class StudentMain {
	public static void main(String[] args) {
		Student[] student = {new Student("???켺", 90, 90, 80),
		          new Student("???ϴ?", 98, 87, 88),
		          new Student("Ȳ????", 86, 99, 93),
		          new Student("??????", 85, 92, 90),
		          new Student("??????", 86, 98, 87)
		};
		String[] title = {"??ȣ","?̸?", "????", "????", "????", "????", "????"};
		int totKor = 0;
		int totEng = 0;
		int totMath = 0;
		int totTotal = 0;
		double totAverage = 0;
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("\t\t\t????ǥ");
		System.out.println("--------------------------------------------------------------");
		for(String t : title) {
			System.out.printf("%s\t",t);
		}
		System.out.println();
		for(Student s : student) {
			s.infoToTal();
			totKor += s.getKor();
			totEng += s.getEng();
			totMath += s.getMath();
			totTotal += s.getTotal();
			totAverage += s.getAverage();
			
			
		}
		double avgKor = totKor / student.length;
		double avgEng = totEng / student.length;
		double avgMath = totMath / student.length;
		double avgTotal = totTotal / student.length;
		double avgAverage = totAverage / student.length;
		System.out.println("--------------------------------------------------------------");
		System.out.printf("???? \t\t %d \t %d \t %d \t %d \t %.1f\n", totKor, totEng, totMath, totTotal, totAverage);
		System.out.printf("???? \t\t %.1f \t %.1f \t %.1f \t %.1f \t %.1f\n", avgKor, avgEng, avgMath, avgTotal, avgAverage);
	}
}
