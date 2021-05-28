package com.lec.ex03_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest1.txt");
			
			String str = "�ȳ��ϼ���\n�ڹ�\n����� �ų��� �ݿ���";
			String str1 = "\n����";
			writer.write(str);
			writer.write(str1);
			System.out.println("���� ���� �Ƹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer != null)
					writer.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
