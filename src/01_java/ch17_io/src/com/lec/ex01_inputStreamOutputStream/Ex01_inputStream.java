package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


// 1. 파일을 연다(Stream 객체 생성) , 2. 데이터를 읽는다.(1byte 단위로 반복한다). 3. 파일을 닫는다.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null;            // null 을 꼭 넣어야한다.
		try {
//			InputStream is = new FileInputStream("txtFile/inTest.txt");  // 1. 파일을 연다
			is = new FileInputStream("txtFile/inTest.txt");

			while(true) {
				int i = is.read(); // 1byte 씩 읽기.
				if(i == -1)       //  -1은 파일의 끝이다. 
					break; 
				System.out.print((char)i + "(" + i + ")");     
			}
			System.out.println();
			System.out.println("Done");				 //2. 데이터를 읽는다.(1byte 단위로 반복한다) 파일이 끝나면 못읽는다.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			
			try {
				if(is != null) is.close();
			} catch (IOException e) {			// 3. 파일을 닫는다.
				// TODO Auto-generated catch block
			}
		}
		
	}

}
