package com.mywave.exercise.robotsimulation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionTest {
	
	private Position position;
	
	@Before
	public void setUp(){
		position = new Position();
	}
	
	@Test
	public void testXPosition(){
		position.setX(3);
		assertEquals(3, position.getX());
	}
	
	@Test
	public void testYPosition(){
		position.setY(2);
		assertEquals(2, position.getY());
	}
	
	@Test
	public void testToString(){
		position = new Position(3, 4);
		assertEquals("3,4,", position.toString());
	}
}
