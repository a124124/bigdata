package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


// 1. ������ ����(Stream ��ü ����) , 2. �����͸� �д´�.(1byte ������ �ݺ��Ѵ�). 3. ������ �ݴ´�.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null;            // null �� �� �־���Ѵ�.
		try {
//			InputStream is = new FileInputStream("txtFile/inTest.txt");  // 1. ������ ����
			is = new FileInputStream("txtFile/inTest.txt");

			while(true) {
				int i = is.read(); // 1byte �� �б�.
				if(i == -1)       //  -1�� ������ ���̴�. 
					break; 
				System.out.print((char)i + "(" + i + ")");     
			}
			System.out.println();
			System.out.println("Done");				 //2. �����͸� �д´�.(1byte ������ �ݺ��Ѵ�) ������ ������ ���д´�.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			
			try {
				if(is != null) is.close();
			} catch (IOException e) {			// 3. ������ �ݴ´�.
				// TODO Auto-generated catch block
			}
		}
		
	}

}