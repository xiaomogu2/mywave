package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Robot;

public class LeftCommand extends RobotCommand {

	public LeftCommand(Robot robot) {
		super(robot);
 	}

	@Override
	protected void execute() {
		robot.left();
	}

}
