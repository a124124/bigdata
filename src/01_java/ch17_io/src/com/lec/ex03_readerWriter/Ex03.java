package com.lec.ex03_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// 1. 키보드로부터 출력할 파일이름을 입력받는다. (txtFile/a.txt)
// 2. 출력하고자 하는 내용을 라인 단위로 반복적으로 받는다.(저장을 끝내고 싶으면 x)
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Writer writer = null;
		String filename;
		String outMsg;
		System.out.println("저장하고자 하는 파일 이름은?");
		filename = sc.next();
		sc.nextLine();
		try {
			writer = new FileWriter("txtFile/" + filename);
			while (true) {
				System.out.println("파일로 출력할 메세지는? (종료는 x)");
				outMsg = sc.nextLine();
				if (outMsg.equalsIgnoreCase("x"))
						break;
			}
			writer.write(outMsg + "\r\n"); // 리눅수에서 돌리려면 \r\n으로 써야한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
