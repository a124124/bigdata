package com.lec.ex01_person;

//등수     이름(NO)         직업      국어(kor)   영어(eng)   수학(mat)    총점
//───────────────────────────────────────
//1등    	송혜교(5번)     배우      100    	100     	100	300

// rank, name, jname, kor, eng, mat, sum

public class PersonDTO {
	private int rank;
	private String name;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;

	// insert 용
	public PersonDTO(String name, String jname, int kor, int eng, int mat) {
		this.name = name;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// select 용

	public PersonDTO(int rank, String name, String jname, int kor, int eng, int mat, int sum) {
		this.rank = rank;
		this.name = name;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rank + "등\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum;
	}

	public int getRank() {
		return rank;
	}

	public String getName() {
		return name;
	}

	public String getJname() {
		return jname;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getMat() {
		return mat;
	}

	public int getSum() {
		return sum;
	}
	
	
}
