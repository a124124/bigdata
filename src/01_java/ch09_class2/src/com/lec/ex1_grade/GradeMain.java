package com.lec.ex1_grade;


public class GradeMain {
	public static void main(String[] args) {
		Grade[] person = {new Grade("���켺", 90, 90, 80),
				          new Grade("���ϴ�", 98, 87, 88),
				          new Grade("Ȳ����", 86, 99, 93),
				          new Grade("������", 85, 92, 90),
				          new Grade("������", 86, 98, 87)
		};
		
		
		System.out.println("\t\t\t����ǥ");
//		System.out.println(" �̸� \t ���� \t ���� \t ���� \t ���� \t ���");
		String[] title = {"�̸�", "����", "����", "����", "����", "���"};
		for(String t : title) {
			System.out.printf("%s\t",t);
			
		}
		System.out.println();
		for(Grade p : person) {
			System.out.println(p.infoTotal());
//			p.infoTotal1();
		}
		
	}
}
