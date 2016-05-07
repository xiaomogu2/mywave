package com.mywave.exercise.robotsimulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest {

	private Direction directionExpected;

	@Test
	public void TestWest() {
		directionExpected = Direction.WEST;
		assertEquals("WEST", directionExpected.toString());
	}

	@Test
	public void TestSouth() {
		directionExpected = Direction.SOUTH;
		assertEquals("SOUTH", directionExpected.toString());
	}

	@Test
	public void testEast() {
		directionExpected = Direction.EAST;
		assertEquals("EAST", directionExpected.toString());
	}

	@Test
	public void testNorth() {
		directionExpected = Direction.NORTH;
		assertEquals("NORTH", directionExpected.toString());
	}

	@Test
	public void testWestTurnLeft() {
		Direction direction = Direction.WEST;
		directionExpected = direction.left();
		assertEquals(Direction.SOUTH, directionExpected);
	}

	@Test
	public void testSouthTurnLeft() {
		Direction direction = Direction.SOUTH;
		directionExpected = direction.left();
		assertEquals(Direction.EAST, directionExpected);
	}

	@Test
	public void testEastTurnLesf() {
		Direction direction = Direction.EAST;
		directionExpected = direction.left();
		assertEquals(Direction.NORTH, directionExpected);
	}

	@Test
	public void testNorthTurnLeft() {
		Direction direction = Direction.NORTH;
		directionExpected = direction.left();
		assertEquals(Direction.WEST, directionExpected);
	}

	@Test
	public void testWestTurnRight() {
		Direction direction = Direction.WEST;
		directionExpected = direction.right();
		assertEquals(Direction.NORTH, directionExpected);
	}

	@Test
	public void testNorthTurnRight() {
		Direction direction = Direction.NORTH;
		directionExpected = direction.right();
		assertEquals(Direction.EAST, directionExpected);
	}

	@Test
	public void tesdEastTurnRight() {
		Direction direction = Direction.EAST;
		directionExpected = direction.right();
		assertEquals(Direction.SOUTH, directionExpected);
	}
	
	@Test
	public void testSouthTurnRight(){
		Direction direction = Direction.SOUTH;
		directionExpected = direction.right();
		assertEquals(Direction.WEST, directionExpected);
	}

}
