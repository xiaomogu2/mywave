package com.mywave.exercise.robotsimulation.exception;

public class FirstValidCommandException extends Exception {
 
	private static final long serialVersionUID = 4806041826058165616L;

	public FirstValidCommandException() {
		super("PLACE Command should be put");
	}

}