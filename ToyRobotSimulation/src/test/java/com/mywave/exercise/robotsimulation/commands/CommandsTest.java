package com.mywave.exercise.robotsimulation.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mywave.exercise.robotsimulation.Direction;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;

public class CommandsTest {

	private Commands commands;
	private RobotCommand robotCommand;

	@Before
	public void before() {
		commands = new Commands();

	}

	@Test
	public void robotCommandTest() {
		Robot robot = new Robot();
  		robotCommand = new RobotCommand(robot) {

			@Override
			protected void execute() {
				robot.setDirection(Direction.SOUTH);
			}
		};
		robotCommand.execute();
 		assertEquals(Direction.SOUTH, robotCommand.getRobot().getDirection());
	}
	
	@Test
	public void setRobotTest(){
		Robot robot = new Robot();
		robot.setDirection(Direction.NORTH);
		robotCommand = new RobotCommand(robot) {

			@Override
			protected void execute() {
 			}
		};
		robotCommand.setRobot(robot);
		assertEquals(Direction.NORTH, robotCommand.getRobot().getDirection());
	}
	
	@Test
	public void testAddCommands(){
 		commands.addCommand(robotCommand);
 		commands.addCommand(robotCommand);
 		assertEquals(2, commands.getRobotCommands().size());
	}
	
	@Test
	public void testExecuteCommands(){
		Robot robot = new Robot();
		robot.setDirection(Direction.NORTH);
		robot.setPosition(new Position(2,2));
		robotCommand = new MoveCommand(robot);
 		commands.addCommand(robotCommand);
 		commands.addCommand(robotCommand);
 		 
		commands.executeCommands();;
 		assertEquals(0, commands.getRobotCommands().size());
	}
	
	@Test
	public void testSetCommand(){
		commands.setRobotCommands(null);
		assertEquals(null,commands.getRobotCommands());
	}
	

}