package com.lec.ex01_person;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDAOTest {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		
		//1. 입력
		PersonDTO newPerson = new PersonDTO("박홍", "배우", 70, 56, 97);
		int result = dao.insertPerson(newPerson);
		System.out.println(result == PersonDAO.SUCCESS? "성공" : "실패");
		
		//2. 직업별 조회
		ArrayList<PersonDTO> person = dao.selectJname("배우");
		System.out.println("배우 직업 조회 결과");
		for(PersonDTO p : person) {
			System.out.println(p);
		}
		
		//3. 전체 조회
		
		person = dao.selectAll();
		System.out.println("전체");
		for(int idx = 0; idx < person.size(); idx++) {
			System.out.println(person.get(idx));
		}
		
		
		//4. 직업 리스트
		
		Vector<String> jnamelist = dao.jnamelist();
		for(int idx = 1; idx < jnamelist.size(); idx++) {
			System.out.println(idx + "번째  : " + jnamelist.get(idx));
		}
	}
}
