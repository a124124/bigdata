package com.lec.loop;
/*
 *   15 부터 50까지 한줄에 5개씩 출력
 *   15 16 17 18 19
 *   
 *   
 * 
 * 
 * 
 * 
 */
public class Ex04_for {
	public static void main(String[] args) {
		
		for (int i=15; i<51; i++) {
			if (i % 5 == 4) {
				System.out.print(i + "\n");
			}else {
				System.out.print(i + " ");	
			}
			
			
			
		}
	}
}
