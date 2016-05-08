package com.mywave.exercise.robotsimulation;

import com.mywave.exercise.robotsimulation.finals.Constants;

public class Table {

	private int demensionX;
	private int demensionY;
	private int originX;
	private int originY;

	public Table(int dimensionX, int demensionY, int originX, int originY) {
		super();
		this.demensionX = dimensionX;
		this.demensionY = demensionY;
		this.originX = originX;
		this.originY = originY;
	}

	public Table() {
		demensionX = Constants.DEMENSIONS_X;
		demensionY = Constants.DEMENSIONS_Y;
		originX = Constants.ORIGIN_X;
		originY = Constants.ORIGIN_Y;
	}

	public int getDemensionX() {
		return demensionX;
	}

	public void setDemensionX(int demensionX) {
		this.demensionX = demensionX;
	}

	public int getDemensionY() {
		return demensionY;
	}

	public void setDemensionY(int demensionY) {
		this.demensionY = demensionY;
	}

	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}

	public int getOriginY() {
		return originY;
	}

	public void setOriginY(int originY) {
		this.originY = originY;
	}

	public boolean isOnTable(Robot robot) {
		Position position = robot.getPosition();
		return (position.getX() >= this.originX && position.getX() <= this.originX+ this.demensionX)
				&& (position.getY() >= this.originY && position.getY() <= this.originY+this.demensionY);
	}

}
