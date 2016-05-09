package com.mywave.exercise.robotsimulation;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mywave.exercise.robotsimulation.commands.LeftCommand;
import com.mywave.exercise.robotsimulation.commands.MoveCommand;
import com.mywave.exercise.robotsimulation.commands.PlaceCommand;
import com.mywave.exercise.robotsimulation.commands.ReportCommand;
import com.mywave.exercise.robotsimulation.commands.RobotCommand;
import com.mywave.exercise.robotsimulation.input.InputData;

import static org.junit.Assert.assertEquals;

public class GameTest {
	
	private Game game;
	private InputData inputData;
	private Table table;
	private Robot robot;
	private List<RobotCommand> robotCommands;
	
	@Before
	public void setup(){
		table = new Table();
		inputData = new InputData();
		robot = new Robot();
		robotCommands = new LinkedList<RobotCommand>();
		inputData.setRobotCommands(robotCommands);
		
	}
	
	@Test
	public void testGetter(){
		 
  		game = new Game(inputData, table,robot);
  		game.setInputData(null);
		assertEquals(null, game.getInputData());
		game.setTable(null);
		assertEquals(null, game.getTable());
		assertEquals(false, game.getRobot() ==null);
		game.setRobot(null);
		assertEquals(true, game.getRobot() ==null);
	}
	
	@Test
	public void testNormalCase1(){
		Robot robot = new Robot();
		Position position = new Position(0,0);
		Direction direction = Direction.NORTH;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("0,1,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Test
	public void testNormalCase2(){
		Robot robot = new Robot();
		Position position = new Position(0,0);
		Direction direction = Direction.NORTH;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new LeftCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("0,0,", robot.getPosition().toString());
		assertEquals(Direction.WEST, robot.getDirection());
	}
	
	@Test
	public void testNormalCase3(){
		Robot robot = new Robot();
		Position position = new Position(1,2);
		Direction direction = Direction.EAST;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new LeftCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("3,3,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Test
	public void testFallingCase1(){
		Robot robot = new Robot();
		Position position = new Position(4,5);
		Direction direction = Direction.NORTH;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("4,5,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Test
	public void testFallingCase2(){
		Robot robot = new Robot();
		Position position = new Position(2,2);
		Direction direction = Direction.NORTH;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		
 		position = new Position(-1,-1);
 		robotCommands.add(new PlaceCommand(robot,position,direction));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals(null, robot.getPosition());
		assertEquals(null, robot.getDirection());
	}
	
	@Test
	public void testAllCase1(){
		Robot robot = new Robot();
		Position position = new Position(2,2);
		Direction direction = Direction.NORTH;
		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		
 		position = new Position(2,2);
 		robotCommands.add(new PlaceCommand(robot,position,direction));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("2,3,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Test
	public void testAllCase2(){
		Robot robot = new Robot();
		Position position = new Position(2,2);
		Direction direction = Direction.NORTH;
 		robotCommands.add(new PlaceCommand(robot, position, direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		
 		position = new Position(-1,-1);
 		robotCommands.add(new PlaceCommand(robot,position,direction));
 		robotCommands.add(new MoveCommand(robot));
		robotCommands.add(new ReportCommand(robot));
		position = new Position(2,3);
 		robotCommands.add(new PlaceCommand(robot,position,direction));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new MoveCommand(robot));
 		robotCommands.add(new LeftCommand(robot));
 		robotCommands.add(new ReportCommand(robot));
 		game = new Game(inputData, table,robot);
		game.play();
		assertEquals("2,5,", robot.getPosition().toString());
		assertEquals(Direction.WEST, robot.getDirection());
	}
	
	
}
