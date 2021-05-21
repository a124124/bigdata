package singleton.step1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE;
	public static SingletonClass getInstance() {
		//SingletonClass 형 객체를 새엇ㅇ하여 주소를 return.
		// 생성된 객체가 있을 경우 그 객체의 주소를 return.
		if(INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	private SingletonClass() {
		
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
}

