package com.lect.ex2_human.main;
import com.lect.ex2_human.*;

// main 함수가 있는 곳은  package com.lect.ex2_human.main;
// man 과 woman 은 package com.lect.ex2_human; 


public class HumanMain {
	public static void main(String[] args) {
		Man man = new Man();
		Woman woman = new Woman();
		Man man2 = new Man(30);
	}

}
