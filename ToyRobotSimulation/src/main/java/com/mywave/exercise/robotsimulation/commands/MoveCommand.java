package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Robot;

public class MoveCommand extends RobotCommand {

	public MoveCommand(Robot robot) {
		super(robot);
 	}

	@Override
	public void execute() {
		robot.move();
	}

}
