package com.mywave.exercise.robotsimulation.input;

import java.util.List;

import com.mywave.exercise.robotsimulation.commands.RobotCommand;
public class InputData {
	
	private List<RobotCommand> robotCommands;

	public List<RobotCommand> getRobotCommands() {
		return robotCommands;
	}

	public void setRobotCommands(List<RobotCommand> robotCommands) {
		this.robotCommands = robotCommands;
	}
	
	
}
