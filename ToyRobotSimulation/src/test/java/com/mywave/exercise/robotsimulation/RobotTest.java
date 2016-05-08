package com.mywave.exercise.robotsimulation;
 
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	
	private Robot robot;
	
	@Before
	public void setup(){
		robot = new Robot();
		Position position = new Position(0, 0);
		Direction direction = Direction.NORTH;
		robot.place(position, direction);
	}
	
	@Test
	public void testPlace(){
		assertEquals("0,0,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Test
	public void testMove(){
 		robot.move();
		assertEquals("0,1,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
	}

	@Test
	public void testReport(){
		robot.move();
 		robot.report();
 		assertEquals("0,1,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
 	}
	
	@Test
	public void testLeft(){
		Position position = new Position(1, 2);
		Direction direction = Direction.EAST;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.left();
		robot.move();
		robot.report();
		assertEquals("3,3,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
  	}
	
	@Test
	public void testRight(){
		Position position = new Position();
		position.setX(3);
		position.setY(2);
		Direction direction = Direction.WEST;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.right();
		robot.move();
		robot.report();
		assertEquals("1,3,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
  	}
	
	@Test
	public void testSouth(){
		Position position = new Position(3, 2);
		Direction direction = Direction.SOUTH;
		robot.place(position, direction);
		robot.move();
 		assertEquals("3,1,", robot.getPosition().toString());
		assertEquals(Direction.SOUTH, robot.getDirection());
  	}
	
	@Test
	public void testRollBackCase1(){
		Position position = new Position(3, 2);
		Direction direction = Direction.SOUTH;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.rollBackMove();
 		assertEquals("3,1,", robot.getPosition().toString());
		assertEquals(Direction.SOUTH, robot.getDirection());
  	}
	
	@Test
	public void testRollBackCase2(){
		Position position = new Position(3, 2);
		Direction direction = Direction.EAST;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.rollBackMove();
 		assertEquals("4,2,", robot.getPosition().toString());
		assertEquals(Direction.EAST, robot.getDirection());
  	}
	
	@Test
	public void testRollBackCase3(){
		Position position = new Position(3, 2);
		Direction direction = Direction.NORTH;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.rollBackMove();
 		assertEquals("3,3,", robot.getPosition().toString());
		assertEquals(Direction.NORTH, robot.getDirection());
  	}
	
	@Test
	public void testRollBackCase4(){
		Position position = new Position(3, 2);
		Direction direction = Direction.WEST;
		robot.place(position, direction);
		robot.move();
		robot.move();
		robot.rollBackMove();
 		assertEquals("2,2,", robot.getPosition().toString());
		assertEquals(Direction.WEST, robot.getDirection());
  	}
	
}
