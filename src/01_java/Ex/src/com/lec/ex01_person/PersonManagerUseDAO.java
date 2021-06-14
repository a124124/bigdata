package com.lec.ex01_person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManagerUseDAO {
	public static void main(String[] args) {
		PersonDAO dao = PersonDAO.getInstance();
		ArrayList<PersonDTO> person;
		Scanner sc = new Scanner(System.in);
		String fn;
		//  do while ��
		do {
			System.out.println("1.�Է� || 2. ������ ��� || 3. ��ü ��� || �׿�. ����");
			fn = sc.next();
			switch (fn) {
			case "1":
//				System.out.println("�̸�, ����, ������ �Է¹޾� insert");
				System.out.println("�̸�");
				String name = sc.next();
				System.out.println("����(���, ����, ����)");
				String jname = sc.next();
				System.out.println("����");
				int kor = sc.nextInt();
				System.out.println("����");
				int eng = sc.nextInt();
				System.out.println("����");
				int mat = sc.nextInt();
				PersonDTO newPerson = new PersonDTO(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				System.out.println(result == PersonDAO.SUCCESS ? "����" : "����");
				break;
				
			case "2":
//				System.out.println("������ �Է¹޾� ������ ���");
				System.out.println("��ȸ�� ������(���, ����, ����)");
				jname = sc.next();
				person = dao.selectJname(jname);
				if(person.isEmpty()) {
					System.out.println("�ش� �������� ����� ����");
				}else {
					System.out.println("rank\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
				break;
				
			case "3":
//				
				person = dao.selectAll();
				if(person.size() == 0) {
					System.out.println("�Էµ� ����� �����ϴ�");
					
				}else {
					System.out.println("rank\t�̸�\t����\t����\t����\t����\t����");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
				
				break;

			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("����");
	}
}
