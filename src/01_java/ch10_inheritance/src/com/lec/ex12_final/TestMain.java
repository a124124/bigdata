package com.lec.ex12_final;

public class TestMain {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.running();
		animal.running();
		animal.stop();
		
		Animal dog = new Dog();
		Dog dog2 = new Dog();
		dog.running();
		dog.running();
		dog.stop();
		//dog2.method();
	}
}
