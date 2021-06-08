package com.lec.ex01_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		
		OutputStream os = null;       //null�� �׻� �Է�������Ѵ�.
		try {
			os = new FileOutputStream("txtFile/outTest.txt");     // ������ ������ ������ ���뿡 �߰��� ���´�.  (append)
			String str = "\n�ѱ�.\n �ǰ��մϴ�";
			byte[] bs = str.getBytes();       // String �� byte �迭�� �ٲٴ� method
			os.write(bs);
			System.out.println("���� ��� ����");
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