package com.lec.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true);
		TimerTask ex1 = new TimerTaskEx01();
		TimerTask ex2 = new TimerTaskEx02();
		timer.schedule(ex1, 2000); // ex1 �۾��� 2���Ŀ� �ѹ� ����
		timer.schedule(ex2, 500, 1000);
		Thread.sleep(10000);
		System.out.println("��");
	}
}
