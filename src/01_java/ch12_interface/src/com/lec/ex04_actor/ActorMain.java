package com.lec.ex04_actor;

public class ActorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actor park = new Actor("�ں���");
		
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		
		System.out.println("=======================");
		
		IFireFighter park1 = new Actor("�ں���");
//		park1.canCatchCriminal();
//		park1.canSearch();
//		park1.makePizza();
//		park1.makeSpaghetti();
		park1.outFire();
		park1.saveMan();
		
		System.out.println("=======================");

		IPoliceMan park2 = new Actor("�ں���");
		
		park2.canCatchCriminal();
		park2.canSearch();
//		park2.makePizza();
//		park2.makeSpaghetti();
//		park2.outFire();
//		park2.saveMan();
		
		System.out.println("=======================");
		
		IChef park3 = new Actor("�ں���");
//		park3.canCatchCriminal();
//		park3.canSearch();
//		park3.outFire();
//		park3.saveMan();
		park3.makePizza();
		park3.makeSpaghetti();
		
		
	}
	

}
