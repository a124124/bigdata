package com.lec.ex05_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream ops = null;
		Writer writer = null;
		PrintWriter printwriter = null;
		try {
//			ops = new FileOutputStream("txtFile/outTest.txt", true);
//			printwriter = new PrintWriter(ops);
			
//			writer = new FileWriter("txtFile/outTest.txt", true);
//			printwriter = new PrintWriter(writer);
			
			printwriter = new PrintWriter("txtFile/outTest.txt"); // ���� append �� �Ұ��ϴ�.
			
			
			System.out.println("�ȳ�\n �ݰ�");
			printwriter.println("�ȳ�\n �ݰ�");
			printwriter.print("print �� �ڵ����� �ȵǼ� ���� �߰�\n");
			
			printwriter.printf("%5s %3d %3d %5.1f\n", "ȫ�浿", 100, 99, 99.5);
			printwriter.printf("%5s %3d %3d %5.1f\n", "1�浿", 100, 99, 99.5);
			printwriter.printf("%5s %3d %3d %5.1f\n", "2�浿", 100, 99, 99.5);
			printwriter.printf("%5s %3d %3d %5.1f\n", "3�浿", 100, 99, 99.5);
			printwriter.printf("%5s %3d %3d %5.1f\n", "4�浿", 100, 99, 99.5);

			

		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(printwriter != null)
					printwriter.close();
				if(ops != null)
					ops.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
