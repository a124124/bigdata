package com.lec.loop;
/* i 가 1일때 누적합은 1이다
 * i 가 10일때 누적함은 55다.
 *  
 *  
 *  
 */


public class Ex09_while {
	public static void main(String[] args) {
		
		int tot = 0;
		int i = 1;
		while(i < 11) {
			tot += i;
			System.out.printf("i가 %d 일 때, 누적합은 %d이다.\n", i, tot);
			i++;
		}
		
		
//		for(int i = 1; i < 11; i++) {
//			tot += i;
//			System.out.printf("i가 %d 일 때, 누적합은 %d이다.\n", i, tot);
//		}
//		
	}
}
