package com.lec.ex03_set;

/*(1) TestMain1.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 ArrayList에 받고,
 *  N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이 콘솔창에 출력하는 프로그램을 구현하시오
	(2) TestMain2.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 HashMap에 받고,
	N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이 콘솔창에 출력하는 프로그램을 구현하시오
	(단, HashMap의 킷값은 전화번호, 데이터는 회원정보로 한다)
*/

public class Customer {
	private String name;
	private String tel;
	private String address;
	
	
	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Customer(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("\n%s %s %s", name, tel, address);
	}
	
	
	
}
