package com.lec.ex;
/*������ ����4) �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �ٶ�      ��� �־�� �ϳ�?
		��Ʈ :  coinUnit[i] + ���� ; �� + money/coinUnit[i]        
			money = money%coinUnit[i];

		��� : 2680����
			500��¥�� X��,	100��¥�� X��,	50��¥�� X��,  10��¥��X��
	// ��Ʈ : coinUnit[i]
*/
public class Quiz4 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coinUnit = {500, 100, 50, 10};
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "��: " + money/coinUnit[i] +"��" );
			money %= coinUnit[i];
		}
	}
}