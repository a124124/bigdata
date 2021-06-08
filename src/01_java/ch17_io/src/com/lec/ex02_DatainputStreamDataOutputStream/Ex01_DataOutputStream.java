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
			dos = new DataOutputStream(fos);	// ���� Stream �� �⺻ Stream�� �̿��ؾ��Ѵ�.
			dos.writeUTF("ȫ�浿");  // String �� ����.
			dos.writeInt(2);       // int�� ����
			dos.writeDouble(90.0); // double �� ����.
			
			dos.writeUTF("ȫ�浿");  // String �� ����.
			dos.writeInt(5);       // int�� ����
			dos.writeDouble(92.0); // double �� ����.
			
			
			System.out.println("���� ���� �Ϸ�");
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