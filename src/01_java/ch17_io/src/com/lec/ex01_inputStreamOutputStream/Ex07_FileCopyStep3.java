package com.lec.ex01_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex07_FileCopyStep3 {
	public static void main(String[] args) {
		File file = new File("txtFile/image.jpg");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/image.jpg");         //입력
			os = new FileOutputStream("txtFile/image_copy11.jpg");   //출력
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				cnt++;
				int readByteCount = is.read(bs);
				if(readByteCount == -1)
					break;
				os.write(bs, 0, readByteCount);       // 
			}
			System.out.println(cnt + "번 while문을 실행하며 복사함");
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
