package com.lec.ex01_string;

public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "        ja va             ";
		System.out.println("1. " + str1.concat(str2)); // str1과 str2를 합친다.
		System.out.println("2. " + str1.substring(3)); // 3번째부터 끝까지
		System.out.println("3. " + str1.substring(3,6)); // 3번째부터 6번째 앞글자까지
		System.out.println("4. " + str1.length()); //문자 길이
		System.out.println("5. " + str1.toUpperCase()); // 모두 대문자로 바꾼다.
		System.out.println("6. " + str1.toLowerCase()); // 모두 소문자로 바꾼다.
		System.out.println("7. " + str1.charAt(3)); // 3번째 글자가 무엇인가.
		System.out.println("8. " + str1.indexOf("b")); // b가 몇번째인지 (앞에서 부터 센다)
		System.out.println("9. " + str1.indexOf("y")); // 없는 스트링의 경우 -1을 return 한다.
		System.out.println("10. " + str1.indexOf("b", 3)); // b를 3 뒤에서부터 찾아서 위치를 알려줌.
		System.out.println("11. " + str1.lastIndexOf("b")); //뒤에서부터 찾아서 위치를 알려준다.
		System.out.println("12. " + str1.equals(str2)); // 대소문자 구분하여 문자가 같은지 다른지 값을 알려준다.
		System.out.println("13. " + str1.equalsIgnoreCase(str2)); // 대소문자 구분없이 문자가 같은가.
		System.out.println("14. " + str3.trim());  // 좌우에 space가 있을경우 제거한다. 글자 사이는 제거하지 않는다.
		System.out.println("15. " + str1.replace("a", "★☆"));  // a를 ★☆로 고친다.
		System.out.println("16. " + str1.replaceAll("a", "★☆")); // 
		System.out.println("최종 str1 = " + str1);
	}
}
