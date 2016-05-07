package com.mywave.exercise.robotsimulation.commands;

import org.junit.Before;
import org.junit.Test;

import com.mywave.exercise.robotsimulation.Direction;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;
import static org.junit.Assert.assertEquals;

public class RobotCommandTest {
	
	private RobotCommand robotCommand;
	private Robot robot;
	
	@Before
	public void setup(){
		robot = new Robot();
		Position position = new Position(2,3);
		Direction direction = Direction.EAST;
		robot.place(position, direction);
	}
	
	@Test
	public void testPlace(){
		Position position = new Position(2,3);
		Direction direction = Direction.EAST;
		robotCommand = new PlaceCommand(robot,position,direction);
		robotCommand.execute();
		assertEquals(Direction.EAST, robotCommand.getRobot().getDirection());
 	}
	
	@Test
	public void testMove(){
		robotCommand = new MoveCommand(robot);
		robotCommand.execute();
		assertEquals(Direction.EAST, robotCommand.getRobot().getDirection());
		assertEquals("3,3,", robotCommand.getRobot().getPosition().toString());
	}
	
	@Test
	public void testLeft(){
		robotCommand = new LeftCommand(robot);
		robotCommand.execute();
		assertEquals(Direction.NORTH, robotCommand.getRobot().getDirection());
		assertEquals("2,3,", robotCommand.getRobot().getPosition().toString());
	}
	
	@Test
	public void testRight(){
		robotCommand = new RightCommand(robot);
		robotCommand.execute();
		assertEquals(Direction.SOUTH, robotCommand.getRobot().getDirection());
		assertEquals("2,3,", robotCommand.getRobot().getPosition().toString());
	}
	
	@Test
	public void testReport(){
		robotCommand = new ReportCommand(robot);
		robotCommand.execute();
		assertEquals(Direction.EAST, robotCommand.getRobot().getDirection());
		assertEquals("2,3,", robotCommand.getRobot().getPosition().toString());
	}
	 
}
