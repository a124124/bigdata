package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		
		OutputStream os = null;       //null을 항상 입력해줘야한다.
		try {
			os = new FileOutputStream("txtFile/outTest.txt");     // 파일이 있으면 기존의 내용에 추가로 적는다.  (append)
			String str = "\n한글.\n 건강합니다";
			byte[] bs = str.getBytes();       // String 을 byte 계열로 바꾸는 method
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
