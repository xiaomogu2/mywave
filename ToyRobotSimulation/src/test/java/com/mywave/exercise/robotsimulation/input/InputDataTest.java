package com.mywave.exercise.robotsimulation.input;

import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Factory;
import org.junit.Before;
import org.junit.Test;

import com.mywave.exercise.robotsimulation.Command;
import com.mywave.exercise.robotsimulation.Direction;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;

import static org.junit.Assert.assertEquals;

public class InputDataTest {
	
	private Robot robot;
	private List<String> lines;
	private InputDataFactory factory;
	
	@Before
	public void setup(){
		lines = new LinkedList<String>();
		robot= new Robot();
		factory = new InputDataFactory();
	}
	
	@Test
	public void testInputCase1(){
  		lines.add("PLACE 1,2,EAST");
		lines.add("MOVE");
		lines.add("MOVE");
		lines.add("LEFT");
		lines.add("MOVE");
		lines.add("RIGHT");
		lines.add("REPORT");
		InputData inputData = factory.createInputData(lines, robot);
		assertEquals(7, inputData.getRobotCommands().size());
		
	}
	
	@Test
	public void testInputCase2(){
  		lines.add("PLACE 1,2,EAST");
		lines.add("MOVE");
		lines.add("MOVE");
		lines.add("LEFT");
		lines.add("MOVE");
		lines.add("GO");
		lines.add("REPORT");
		InputData inputData = factory.createInputData(lines, robot);
		assertEquals(6, inputData.getRobotCommands().size());
		
	}
}
