package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일을 연다 2. 읽는다 3. 파일을 닫는다
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[20];
			while(true) {
//				int i = is.read();   // 1byte씩 읽기
				int readByteCount = is.read(bs);      //       0123456789012345678901234567890123456789
				if(readByteCount == -1) 
					break;
				for(byte b : bs) {
					System.out.print((char)b);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 못찾음" + e.getMessage());         // 1단계.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO예외" + e.getMessage());
		}finally {
			try {
				if(is != null)
					is.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
}
