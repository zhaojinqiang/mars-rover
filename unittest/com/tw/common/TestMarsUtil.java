package com.tw.common;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tw.dto.Rover;

public class TestMarsUtil {

	@BeforeTest
	public void init(){
		Rover rover1 = new Rover();
		rover1.setX_value(1);
		rover1.setY_value(2);
		rover1.setRoverId(1);
		
		Rover rover2 = new Rover();
		rover2.setX_value(3);
		rover2.setY_value(5);
		rover2.setRoverId(3);
		
		MarsUtil.rovers.add(rover1);
		MarsUtil.rovers.add(rover2);
	}
	
	@AfterTest
	public void destory(){
		MarsUtil.rovers.removeAll(MarsUtil.rovers);
	}
	
	@Test
	public void testIsDupRover() {
		Rover testRover = new Rover();
		testRover.setRoverId(1);
		testRover.setX_value(3);
		testRover.setY_value(5);
		Assert.assertEquals(MarsUtil.isDupRover(testRover), true);
	}

}
