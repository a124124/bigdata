package com.lec.ex02_DatainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);	// 보조 Stream 은 기본 Stream을 이용해야한다.
			dos.writeUTF("홍길동");  // String 값 저장.
			dos.writeInt(2);       // int값 저장
			dos.writeDouble(90.0); // double 값 저장.
			
			dos.writeUTF("홍길동");  // String 값 저장.
			dos.writeInt(5);       // int값 저장
			dos.writeDouble(92.0); // double 값 저장.
			
			
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos != null)
					dos.close();
				if(fos != null)
					fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
}
