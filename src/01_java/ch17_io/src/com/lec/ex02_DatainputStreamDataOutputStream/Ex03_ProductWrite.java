package com.lec.ex02_DatainputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		// n 을 입력할 때까지 재고(상품명, 가격, 재고량)을 출력
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("입력할 재고가 더 있습니까?(y/n)");
				answer = sc.next();
				if(answer.equalsIgnoreCase("N")) {
					break;
				}else if(answer.equalsIgnoreCase("y")) {
					System.out.println("상품명");
					sc.nextLine();
					dos.writeUTF(sc.nextLine());
					System.out.println("가격");
					dos.writeInt(sc.nextInt());
					System.out.println("개수");
					dos.writeInt(sc.nextInt());
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(dos != null)
					dos.close();
				if(fos != null)
					fos.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			sc.close();
			System.out.println("종료");
		}
	}
}
