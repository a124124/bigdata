package com.lec.ex01_person;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDAOTest {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		
		//1. �Է�
		PersonDTO newPerson = new PersonDTO("��ȫ", "���", 70, 56, 97);
		int result = dao.insertPerson(newPerson);
		System.out.println(result == PersonDAO.SUCCESS? "����" : "����");
		
		//2. ������ ��ȸ
		ArrayList<PersonDTO> person = dao.selectJname("���");
		System.out.println("��� ���� ��ȸ ���");
		for(PersonDTO p : person) {
			System.out.println(p);
		}
		
		//3. ��ü ��ȸ
		
		person = dao.selectAll();
		System.out.println("��ü");
		for(int idx = 0; idx < person.size(); idx++) {
			System.out.println(person.get(idx));
		}
		
		
		//4. ���� ����Ʈ
		
		Vector<String> jnamelist = dao.jnamelist();
		for(int idx = 1; idx < jnamelist.size(); idx++) {
			System.out.println(idx + "��°  : " + jnamelist.get(idx));
		}
	}
}