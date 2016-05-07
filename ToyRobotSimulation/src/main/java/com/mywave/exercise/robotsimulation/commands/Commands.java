package com.mywave.exercise.robotsimulation.commands;

import java.util.LinkedList;
import java.util.List;

/*
 *   Command pattern designed for executing commands 
 */
public class Commands {

	private List<RobotCommand> robotCommands = new LinkedList<RobotCommand>();

	public void addCommand(RobotCommand robotCommand) {
		robotCommands.add(robotCommand);
	}

	public void executeCommands() {
		for (RobotCommand robotCommand : robotCommands) {
			robotCommand.execute();
		}
		robotCommands.clear();
	}

	public List<RobotCommand> getRobotCommands() {
		return robotCommands;
	}

	public void setRobotCommands(List<RobotCommand> robotCommands) {
		this.robotCommands = robotCommands;
	}

}