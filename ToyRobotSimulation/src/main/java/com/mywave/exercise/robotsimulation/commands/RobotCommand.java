package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Robot;

public abstract class RobotCommand {
	
	protected Robot robot;

	public RobotCommand(Robot robot) {
 		this.robot = robot;
	}
	
	public abstract void execute();

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	
}
