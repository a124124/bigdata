package com.lec.ex03_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest1.txt");
			
			String str = "안녕하세요\n자바\n비오는 신나는 금요일";
			String str1 = "\n끼엑";
			writer.write(str);
			writer.write(str1);
			System.out.println("저장 성공 아마도");
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
