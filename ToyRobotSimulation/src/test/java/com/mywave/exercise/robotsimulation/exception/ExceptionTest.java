package com.mywave.exercise.robotsimulation.exception;
 
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.mywave.exercise.robotsimulation.Command;
import com.mywave.exercise.robotsimulation.Position;
import com.mywave.exercise.robotsimulation.Robot;
import com.mywave.exercise.robotsimulation.Table;
import com.mywave.exercise.robotsimulation.commands.MoveCommand;
import com.mywave.exercise.robotsimulation.commands.PlaceCommand;
import com.mywave.exercise.robotsimulation.commands.RobotCommand;
import com.mywave.exercise.robotsimulation.finals.Constants;

public class ExceptionTest {
	
	@Test(expected = FirstValidCommandException.class)
	public void testFirstValidCommandException() throws FirstValidCommandException{
		List<RobotCommand> list = new LinkedList<RobotCommand>();
		list.add(new MoveCommand(null));
		for(RobotCommand robotCommand: list){
			if(!(robotCommand instanceof PlaceCommand)){
				throw new FirstValidCommandException();
			}
		}
	}
	
	@Test(expected = InvalidCommandException.class)
	public void testInvalidCommandException() throws InvalidCommandException{
		List<String> commands = new LinkedList<String>();
		commands.add("TEST");
		for(String command: commands){
			try {
				if(Command.valueOf(command)==null){
					
				}
			} catch (Exception e) {
				throw new InvalidCommandException(command);
			}
		}
	}
	
	@Test(expected = NotOnTheTableException.class)
	public void testINotOnTheTableException() throws NotOnTheTableException{
		Table table = new Table();
		Robot robot = new Robot();
		robot.setPosition(new Position(7, 2));
		if(!table.isOnTable(robot)){
			throw new NotOnTheTableException(Constants.NOT_ON_THE_TABLE_MSG);
		}
		 
	}
}
