package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		int i = 10 ; // 4byte ¥�� ���� i �ָӴϿ� 10�� �Ҵ� 
		byte j = 20 ; // 1byte ¥�� ���� j �ָӴϿ� 20�� �Ҵ�
		double d = 1 ; // 8byte ¥�� �Ǽ� d �ָӴϿ� 0.1�� �Ҵ�
		char c = 'C' ; // 2byte ¥�� ���� c �ָӴϿ� 'C'�� �Ҵ�
		boolean ok = true ; // boolean ���� true �ƴϸ� false �ۿ� �Ҵ���� �ʴ´�.
		long l = 2200000000L ;
		System.out.println("i\t j\t d");  // \t �� ��
		System.out.println(i+"\t"+j+"\t"+d); // println �� �����ؼ� ���
		System.out.println("c\t c");	//print�� ������ ���� ����
		System.out.println("���� c�� ���� �ڵ�\n");			// \n �� ����
		System.out.printf("c=%c , c�� �ڵ尪=%d\n", c, (int)c);
		System.out.println(ok);
		System.out.printf("ok=%b=n", ok);
		System.out.printf("l=%d", l);
		System.out.printf("d=%5.2f", d);
		
		// %d (����) %f(�Ǽ�) %b(�Ҹ�,true or false) %x (16����) %c (���� 1��) %s (���ڿ�)
	}
}
