package com.lec.ex02_DatainputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_ProductList {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		ArrayList<Product> product = new ArrayList<Product>();
		
		try {
			fis = new FileInputStream("txtFile/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				String name = dis.readUTF(); // �ҷ�����
				int price = dis.readInt();
				int ps = dis.readInt();
				
				product.add(new Product(name, price, ps));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dis != null)
					dis.close();
				if(fis != null)
					fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		if(product.isEmpty()) {
			System.out.println("��� �����ϴ�");
		}else {
			System.out.println("���Ǹ�\t����\t���");
			for(Product p : product) {
				System.out.println(p);
			}
		}
	}
}
