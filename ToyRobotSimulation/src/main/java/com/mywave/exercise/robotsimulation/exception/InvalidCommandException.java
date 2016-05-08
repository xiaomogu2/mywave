package com.mywave.exercise.robotsimulation.exception;

public class InvalidCommandException extends IllegalArgumentException {

 
	private static final long serialVersionUID = -654737894666299909L;

	public InvalidCommandException(String string) {
		super("Invalid command: "+string);
	}
}
