package com.mywave.exercise.robotsimulation.input;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mywave.exercise.robotsimulation.Command;
import com.mywave.exercise.robotsimulation.Direction;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;
import com.mywave.exercise.robotsimulation.commands.LeftCommand;
import com.mywave.exercise.robotsimulation.commands.MoveCommand;
import com.mywave.exercise.robotsimulation.commands.PlaceCommand;
import com.mywave.exercise.robotsimulation.commands.ReportCommand;
import com.mywave.exercise.robotsimulation.commands.RightCommand;
import com.mywave.exercise.robotsimulation.commands.RobotCommand;
import com.mywave.exercise.robotsimulation.exception.InvalidCommandException;
import com.mywave.exercise.robotsimulation.finals.Constants;
import com.mywave.exercise.robotsimulation.util.ValidationUtil;

public class InputDataFactory {

	public InputData createInputData(List<String> lines, Robot robot) {
		InputData inputData = new InputData();
		inputData.setRobotCommands(getCommands(lines, robot));
		return inputData;
	}

	private RobotCommand getRobotCommand(Command command, Robot robot,
			String line) {
		switch (command) {
		case PLACE:
			return place(robot, line);
		case MOVE:
			return new MoveCommand(robot);
		case LEFT:
			return new LeftCommand(robot);
		case RIGHT:
			return new RightCommand(robot);
		case REPORT:
			return new ReportCommand(robot);
		}
		return null;
	}

	private PlaceCommand place(Robot robot, String line) {
		String[] array = line.split(" ")[1].split("[,]");
		int x = Integer.parseInt(array[0]);
		int y = Integer.parseInt(array[1]);
		Position position = new Position(x, y);
		Direction direction = Direction.valueOf(array[2]);
		return new PlaceCommand(robot, position, direction);
	}

	private List<RobotCommand> getCommands(List<String> lines, Robot robot) {
		List<RobotCommand> commands = new LinkedList<RobotCommand>();
		for (String line : lines) {
			line = line.toUpperCase();
			if (!"".equals(line.trim())) {
				try {
					if (ValidationUtil.isValidCommand(line)) {
						String cmd = line.split(" ")[0];
 						Command command = Command.valueOf(cmd);
						RobotCommand robotCommand = getRobotCommand(command,
								robot, line);
						commands.add(robotCommand);
					} else {
						throw new InvalidCommandException(line);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
		return commands;

	}

}
