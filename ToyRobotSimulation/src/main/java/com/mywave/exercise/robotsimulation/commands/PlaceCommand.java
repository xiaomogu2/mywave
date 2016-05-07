package com.mywave.exercise.robotsimulation.commands;

import com.mywave.exercise.robotsimulation.Direction;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;

public class PlaceCommand extends RobotCommand {

	private Position position;
	private Direction direction;

	public PlaceCommand(Robot robot, Position position, Direction direction) {
		super(robot);
		this.position = position;
		this.direction = direction;
	}

	@Override
	protected void execute() {
		robot.place(position, direction);
	}

}
