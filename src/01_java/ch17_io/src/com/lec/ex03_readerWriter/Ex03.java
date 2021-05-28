package com.lec.ex03_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// 1. Ű����κ��� ����� �����̸��� �Է¹޴´�. (txtFile/a.txt)
// 2. ����ϰ��� �ϴ� ������ ���� ������ �ݺ������� �޴´�.(������ ������ ������ x)
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Writer writer = null;
		String filename;
		String outMsg;
		System.out.println("�����ϰ��� �ϴ� ���� �̸���?");
		filename = sc.next();
		sc.nextLine();
		try {
			writer = new FileWriter("txtFile/" + filename);
			while (true) {
				System.out.println("���Ϸ� ����� �޼�����? (����� x)");
				outMsg = sc.nextLine();
				if (outMsg.equalsIgnoreCase("x"))
						break;
			}
			writer.write(outMsg + "\r\n"); // ���������� �������� \r\n���� ����Ѵ�.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
