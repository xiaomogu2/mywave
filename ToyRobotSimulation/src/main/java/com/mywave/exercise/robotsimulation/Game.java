package com.mywave.exercise.robotsimulation;

import java.util.LinkedList;
import java.util.List;

import com.mywave.exercise.robotsimulation.commands.MoveCommand;
import com.mywave.exercise.robotsimulation.commands.PlaceCommand;
import com.mywave.exercise.robotsimulation.commands.RobotCommand;
import com.mywave.exercise.robotsimulation.exception.FirstValidCommandException;
import com.mywave.exercise.robotsimulation.exception.NotOnTheTableException;
import com.mywave.exercise.robotsimulation.finals.Constants;
import com.mywave.exercise.robotsimulation.input.InputData;

public class Game {

	private InputData inputData;
	private Table table;
	private List<RobotCommand> robotCommands = new LinkedList<RobotCommand>();
	private Robot robot;
	private boolean gameInProgress = false;

	public Game(InputData inputData, Table table, Robot robot) {
		super();
		this.inputData = inputData;
		this.table = table;
		this.robot = robot;
	}

	public void play() {
		initData();
		executeCommands();
	}

	public void initData() {
		for (RobotCommand robotCommand : inputData.getRobotCommands()) {
			robotCommands.add(robotCommand);
		}
	}

	private void executeCommands() {
		for (RobotCommand robotCommand : robotCommands) {
 			if (isValidCmd(robotCommand)) {
				System.out.println(currentCmd(robotCommand));
				robotCommand.execute();
				checkMove(robotCommand);
			}
		}
		robotCommands.clear();
	}

	private void checkMove(RobotCommand robotCommand) {
 		if (isMoveCmd(robotCommand) && !isOnTable(robot.getPosition())) {
			try {
				throw new NotOnTheTableException(Constants.ROBOT_FALLING_MSG);
			} catch (NotOnTheTableException e) {
				System.out.println(e.getMessage());
				robot.rollBackMove();
			}
		}
	}

	public boolean isValidCmd(RobotCommand robotCommand) {
		try {

			// check is PLACE cmd first
			if (!gameInProgress) {
				gameInProgress = isPlaceCmd(robotCommand);
			}

 			if (!gameInProgress) {
				throw new FirstValidCommandException();
			} 

 			// Then check is in the table range
			if (isPlaceCmd(robotCommand)) {
				gameInProgress = isOnTable(((PlaceCommand) robotCommand)
						.getPosition());
			}

			if (!gameInProgress) {
				throw new NotOnTheTableException(Constants.NOT_ON_THE_TABLE_MSG);
			}

		} catch (NotOnTheTableException e) {
			System.out.println(e.getMessage());
			gameInProgress = false;
			robot.reset();
		} catch (FirstValidCommandException e) {
			System.out.println(currentCmd(robotCommand)+" "+e.getMessage());
			gameInProgress = false;
			robot.reset();
		}

		return gameInProgress;
	}

	private boolean isOnTable(Position position) {
		return table.isOnTable(position);
	}

	private boolean isPlaceCmd(RobotCommand robotCommand) {
		return (robotCommand instanceof PlaceCommand);
	}

	private boolean isMoveCmd(RobotCommand robotCommand) {
		return (robotCommand instanceof MoveCommand);
	}

	public InputData getInputData() {
		return inputData;
	}

	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	private String currentCmd(RobotCommand robotCommand){
		return "Current: "+robotCommand.getClass().getSimpleName();
	}
}
