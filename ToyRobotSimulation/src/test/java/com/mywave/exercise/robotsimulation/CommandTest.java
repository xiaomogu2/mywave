package com.mywave.exercise.robotsimulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandTest {
	
	
	private Command commandExcepted;

	@Test
	public void TestPlace() {
		commandExcepted = Command.PLACE;
		assertEquals("PLACE", commandExcepted.toString());
	}

	@Test
	public void TestMove() {
		commandExcepted = Command.MOVE;
		assertEquals("MOVE", commandExcepted.toString());
	}

	@Test
	public void testLeft() {
		commandExcepted = Command.LEFT;
		assertEquals("LEFT", commandExcepted.toString());
	}

	@Test
	public void testRight() {
		commandExcepted = Command.RIGHT;
		assertEquals("RIGHT", commandExcepted.toString());
	}
	
	@Test
	public void testReport() {
		commandExcepted = Command.REPORT;
		assertEquals("REPORT", commandExcepted.toString());
	}

}
