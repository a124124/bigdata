package com.lec.ex01_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_FileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/image.jpg");         //�Է�
			os = new FileOutputStream("txtFile/image_copy.jpg");   //���
			int cnt = 0;
			while(true) {
				cnt++;
				int i = is.read();
				if(i == -1)
					break;
				os.write(i);
			}
			System.out.println(cnt + "�� while���� �����ϸ� ������");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
				try {
					if(is != null)
						is.close();
					if(os != null)
						os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}