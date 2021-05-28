package com.lec.ex03_readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			while(true) {
				int i = reader.read();
				if(i == -1) 
					break;
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(reader != null) 
					reader.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
