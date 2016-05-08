package com.mywave.exercise.robotsimulation;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.mywave.exercise.robotsimulation.factory.InputData;
import com.mywave.exercise.robotsimulation.factory.InputDataFactory;

public class ToyRobotSimulation {
	
	public static void main(String[] args) {
		//create robot
		Robot robot = new Robot();
		
		//create commands from file
		List<String> lines = getCommandsStr(args);
		
		InputDataFactory factory = new InputDataFactory();
		InputData inputData =factory.createInputData(lines, robot);
		
		//create table;
		Table table = new Table();
		
		//create game
		Game game = new Game(inputData, table, robot);
		game.play();
	}
	
	private static List<String> getCommandsStr(String[] args){
		String path = "./file/commands.txt";
		if(args!=null && args.length >0){
			path = args[1];
		}
		
		List<String> lines = new LinkedList<String>();
		try {
			lines = FileUtils.readLines(new File(path));
		} catch (IOException e) {
			 System.out.println(e.getMessage());
		}
		return lines;
	}
}
