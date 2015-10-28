package com.tw.state;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tw.dto.Rover;

public class TestNorthState {

Rover rover1 = new Rover();
	
	@BeforeTest
	public void init(){
		rover1.setX_value(1);
		rover1.setY_value(2);
		rover1.setRoverId(1);
		rover1.setFaceString("N");
	}

	@Test
	public void testHandleLeft() {
		MarsContext marsContext = new MarsContext();
		marsContext.setRover(rover1);
		NorthState northState = new NorthState(rover1);
		northState.handleLeft(marsContext);
	}

	@Test
	public void testHandleRight() {
		MarsContext marsContext = new MarsContext();
		marsContext.setRover(rover1);
		NorthState northState = new NorthState(rover1);
		northState.handleRight(marsContext);
	}

	@Test
	public void testHandleMove() {
		MarsContext marsContext = new MarsContext();
		marsContext.setRover(rover1);
		NorthState northState = new NorthState(rover1);
		northState.handleMove(marsContext);
	}

}
