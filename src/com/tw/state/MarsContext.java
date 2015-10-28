package com.tw.state;

import com.tw.dto.Rover;

public class MarsContext{
  
	private Rover rover = null;
	
	private State state = null;
	
	public void setState(State state){
		this.state = state;
	}
	
	public Rover getRover() {
		return rover;
	}

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public void left() {
		state.handleLeft(this);
	}

	public void move() {
		state.handleMove(this);
	}

	public void right() {
		state.handleRight(this);
	}

}
