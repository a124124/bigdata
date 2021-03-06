package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1. 파일을 연다 2. 데이터를 쓴다 3. 파일을 닫는다
public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");
			byte[] bs = {'H', 'e', 'l', 'l', 'o'};
			for(int i = 0; i < bs.length; i++) {
				os.write(bs[i]);
			}
			os.write(bs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
		}
	}
}
