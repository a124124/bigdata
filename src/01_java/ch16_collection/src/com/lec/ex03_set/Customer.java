package com.lec.ex03_set;

/*(1) TestMain1.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� ArrayList�� �ް�,
 *  N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� ����ϴ� ���α׷��� �����Ͻÿ�
	(2) TestMain2.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� HashMap�� �ް�,
	N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� ����ϴ� ���α׷��� �����Ͻÿ�
	(��, HashMap�� Ŷ���� ��ȭ��ȣ, �����ʹ� ȸ�������� �Ѵ�)
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