package com.mywave.exercise.robotsimulation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mywave.exercise.robotsimulation.finals.Constants;

public class TableTest {
	
	private Table table;
	
	@Before
	public void setup(){
		table = new Table();
	}
	
	@Test
	public void testGetDemisionX(){
		assertEquals(Constants.DEMENSIONS_X, table.getDemensionX());
	}
	
	@Test
	public void testGetDemesionY(){
		assertEquals(Constants.DEMENSIONS_Y, table.getDemensionY());
	}
	
	@Test
	public void testGetOriginX(){
		assertEquals(Constants.ORIGIN_X, table.getOriginX());
	}
	
	@Test
	public void testGetOriginY(){
		assertEquals(Constants.ORIGIN_Y, table.getOriginY());
	}
	
	@Test
	public void testIsOnTableCase1(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(1, 1));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase2(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(1, 4));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase3(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(1, 10));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase4(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(3, 1));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase5(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(3, 4));
		assertEquals(true, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase6(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(3, 10));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase7(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(7, 1));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase8(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(7, 4));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase9(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(7, 10));
		assertEquals(false, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase10(){
		table = new Table(3, 7, 2, 2);
		Robot robot = new Robot();
		robot.setPosition(new Position(2, 9));
		assertEquals(true, table.isOnTable(robot));
	}
	
	@Test
	public void testIsOnTableCase11(){
		table = new Table();
		table.setDemensionX(3);
		table.setDemensionY(7);
		table.setOriginX(2);
		table.setOriginY(4);
		Robot robot = new Robot();
		robot.setPosition(new Position(5, 11));
		assertEquals(true, table.isOnTable(robot));
	}
}
