package com.lec.ex01_person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagerUseDAO {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		ArrayList<PersonDTO> person;
		Scanner sc = new Scanner(System.in);
		String fn;
		//  do while 문
		do {
			System.out.println("1.입력 || 2. 직업별 출력 || 3. 전체 출력 || 그외. 종료");
			fn = sc.next();
			switch (fn) {
			case "1":
//				System.out.println("이름, 직업, 국영수 입력받아 insert");
				System.out.println("이름");
				String name = sc.next();
				System.out.println("직업(배우, 가수, 엠씨)");
				String jname = sc.next();
				System.out.println("국어");
				int kor = sc.nextInt();
				System.out.println("영어");
				int eng = sc.nextInt();
				System.out.println("수학");
				int mat = sc.nextInt();
				PersonDTO newPerson = new PersonDTO(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				System.out.println(result == PersonDAO.SUCCESS ? "성공" : "실패");
				break;
				
			case "2":
//				System.out.println("직업명 입력받아 총점순 출력");
				System.out.println("조회할 직업명(배우, 가수, 엠씨)");
				jname = sc.next();
				person = dao.selectJname(jname);
				if(person.isEmpty()) {
					System.out.println("해당 직업명의 사람이 없음");
				}else {
					System.out.println("rank\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
				break;
				
			case "3":
//				
				person = dao.selectAll();
				if(person.size() == 0) {
					System.out.println("입력된 사람이 없습니다");
					
				}else {
					System.out.println("rank\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
				
				break;

			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("종료");
	}
}
