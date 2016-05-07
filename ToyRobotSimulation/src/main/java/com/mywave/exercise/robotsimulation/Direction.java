package com.mywave.exercise.robotsimulation;

public enum Direction {
	
	WEST,NORTH,EAST,SOUTH;
	
	public Direction left(){
		int position = ordinal()-1;
		Direction[] directions = Direction.values();
		int max = directions.length-1;
		int index =  position <0?max:position;
		return Direction.values()[index];
	}
	
	public Direction right(){
		int position = ordinal()+1;
		Direction[] directions = Direction.values();
		int max = directions.length-1;
		int index = position>max?0:position;
		return Direction.values()[index];
	}
	
}
