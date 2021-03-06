package com.lec.ex09_robot;

public class RobotOrder {
	public void action(Robot robot) {
		//Robot 에게 dance(), sing(), draw() 를 시키는 로직
		
		if(robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		}else if(robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		}
	}
}
