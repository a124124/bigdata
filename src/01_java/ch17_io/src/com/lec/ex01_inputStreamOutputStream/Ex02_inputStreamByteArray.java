package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ������ ���� 2. �д´� 3. ������ �ݴ´�
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[20];
			while(true) {
//				int i = is.read();   // 1byte�� �б�
				int readByteCount = is.read(bs);      //       0123456789012345678901234567890123456789
				if(readByteCount == -1) 
					break;
				for(byte b : bs) {
					System.out.print((char)b);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ��ã��" + e.getMessage());         // 1�ܰ�.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO����" + e.getMessage());
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