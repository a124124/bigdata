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
				String name = dis.readUTF(); // 불러오기
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
			System.out.println("재고가 없습니다");
		}else {
			System.out.println("물건명\t가격\t재고");
			for(Product p : product) {
				System.out.println(p);
			}
		}
	}
}
