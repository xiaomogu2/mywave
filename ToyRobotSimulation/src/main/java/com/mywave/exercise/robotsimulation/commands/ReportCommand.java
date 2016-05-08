package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Robot;

public class ReportCommand extends RobotCommand {

	public ReportCommand(Robot robot) {
		super(robot);
 	}

	@Override
	public void execute() {
		robot.report();
	}

}
