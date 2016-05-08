package com.mywave.exercise.robotsimulation;

public class Robot {

	public final static int MOVE_FORWARD = 1;
	public final static int MOVE_BACK = -1;
	public static final String FORMAT =  "Ouput: %s%s\n";
			
	private Position position;
	private Direction direction;
 
	public Robot() {

	}

	public void left() {
		direction = direction.left();
	}

	public void right() {
		direction = direction.right();
	}

	public void report() {
 		System.out.printf(FORMAT,position,direction.toString());
	}

	public void place(Position position, Direction direction) {
		setPosition(position);
		setDirection(direction);
	}

	// move based on the direction
	public void move() {
		switch (direction) {
		case WEST:
			move(MOVE_BACK, 0);
			break;
		case NORTH:
			move(0, MOVE_FORWARD);
			break;
		case EAST:
			move(MOVE_FORWARD, 0);
			break;
		case SOUTH:
			move(0, MOVE_BACK);
			break;
		}
	}
	
	public void rollBackMove() {
		switch (direction) {
		case WEST:
			move(MOVE_FORWARD, 0);
			break;
		case NORTH:
			move(0, MOVE_BACK);
			break;
		case EAST:
			move(MOVE_BACK, 0);
			break;
		case SOUTH:
			move(0, MOVE_FORWARD);
			break;
		}
	}

	private void move(int xMove, int yMove) {
		int xCurrent = position.getX();
		int yCurrent = position.getY();

		position.setX(xCurrent + xMove);
		position.setY(yCurrent + yMove);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void reset() {
		this.direction =null;
		position = null;
	}
}
