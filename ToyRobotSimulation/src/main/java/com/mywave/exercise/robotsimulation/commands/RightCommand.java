package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Robot;

public class RightCommand extends RobotCommand {

	public RightCommand(Robot robot) {
		super(robot);
 	}

	@Override
	protected void execute() {
		robot.right();
	}

}
