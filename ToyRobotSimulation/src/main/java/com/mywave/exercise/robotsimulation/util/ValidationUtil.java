package com.mywave.exercise.robotsimulation.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
	
	public static boolean isValidCommand(String line) {
		Pattern r = Pattern
				.compile("(LEFT|MOVE|RIGHT|REPORT|(PLACE (\\d.*),(\\d.*),(NORTH|SOUTH|EAST|WEST)))");
		Matcher m = r.matcher(line);
		return m.find();
	}
}
