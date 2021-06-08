package com.lec.ex01_string;

public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "        ja va             ";
		System.out.println("1. " + str1.concat(str2)); // str1�� str2�� ��ģ��.
		System.out.println("2. " + str1.substring(3)); // 3��°���� ������
		System.out.println("3. " + str1.substring(3,6)); // 3��°���� 6��° �ձ��ڱ���
		System.out.println("4. " + str1.length()); //���� ����
		System.out.println("5. " + str1.toUpperCase()); // ��� �빮�ڷ� �ٲ۴�.
		System.out.println("6. " + str1.toLowerCase()); // ��� �ҹ��ڷ� �ٲ۴�.
		System.out.println("7. " + str1.charAt(3)); // 3��° ���ڰ� �����ΰ�.
		System.out.println("8. " + str1.indexOf("b")); // b�� ���°���� (�տ��� ���� ����)
		System.out.println("9. " + str1.indexOf("y")); // ���� ��Ʈ���� ��� -1�� return �Ѵ�.
		System.out.println("10. " + str1.indexOf("b", 3)); // b�� 3 �ڿ������� ã�Ƽ� ��ġ�� �˷���.
		System.out.println("11. " + str1.lastIndexOf("b")); //�ڿ������� ã�Ƽ� ��ġ�� �˷��ش�.
		System.out.println("12. " + str1.equals(str2)); // ��ҹ��� �����Ͽ� ���ڰ� ������ �ٸ��� ���� �˷��ش�.
		System.out.println("13. " + str1.equalsIgnoreCase(str2)); // ��ҹ��� ���о��� ���ڰ� ������.
		System.out.println("14. " + str3.trim());  // �¿쿡 space�� ������� �����Ѵ�. ���� ���̴� �������� �ʴ´�.
		System.out.println("15. " + str1.replace("a", "�ڡ�"));  // a�� �ڡٷ� ��ģ��.
		System.out.println("16. " + str1.replaceAll("a", "�ڡ�")); // 
		System.out.println("���� str1 = " + str1);
	}
}