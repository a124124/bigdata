package singleton.step2;

public class TestMain {
	public static void main(String[] args) {
//		FirstClass firstObj = new FirstClass();
//		System.out.println("--------------------------");
//		SecondClass secondObj = new SecondClass();
//		System.out.println("--------------------------");
//
//		SingletonClass singObj = SingletonClass.getInstance();
//		System.out.println("main 안에서의 singObj 값은 : " + singObj.getI());
//		
//		
//		
//		SingletonClass singObj = SingletonClass.getInstance();
//		System.out.println(singObj.getI());
//		singObj.setI(999);
//		SingletonClass singObj1 = SingletonClass.getInstance();
//		System.out.println(singObj.getI());
//		System.out.println(singObj1.getI());
//		
//		
//		
		FirstClass firstObj = new FirstClass();
		System.out.println("-----------------------");
		SecondClass secondObj = new SecondClass();
		System.out.println("------------------------");
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("main 함수에서 singObj.i = " + singObj.getI());
		
		
	}
}
