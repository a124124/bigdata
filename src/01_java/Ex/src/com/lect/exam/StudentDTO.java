package com.lect.exam;

public class StudentDTO {
	private int rank;
	private String sNo;
	private String sName;
	private int mNo;
	private int score;
	private int sExpel;
	private String mName;
	
	

	public StudentDTO(String sNo, String sName, int mNo, int score) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.score = score;
		this.mNo = mNo;
	}
	


	public StudentDTO(String sNo, String sName, int mNo, int score, String mName) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.mNo = mNo;
		this.score = score;
		this.mName = mName;
	}



	public StudentDTO(int rank, String sName, String mName,int score) {
		this.rank = rank;
		this.sName = sName;
		this.score = score;
		this.mName = mName;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(rank!=0)
			return rank + "\t" + sName + "\t" + mName + "\t" + score;
		else
			return sNo + "\t" + sName + "\t" + mName + "\t" + score;
	}


	public String getsNo() {
		return sNo;
	}


	public String getsName() {
		return sName;
	}


	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	public int getScore() {
		return score;
	}


	public int getsExpel() {
		return sExpel;
	}


	public void setsExpel(int sExpel) {
		this.sExpel = sExpel;
	}


	public void setsNo(String sNo) {
		this.sNo = sNo;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}




	public int getmNo() {
		return mNo;
	}


	public String getmName() {
		return mName;
	}
	
	
	
	
	
}
