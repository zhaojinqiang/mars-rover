package com.tw.state;

import com.tw.common.MarsUtil;
import com.tw.dto.Rover;
/**
 * north
 * @author zhaojinqiang
 *
 */
public class NorthState extends State{

	public NorthState(Rover rover) {
		super(rover);
	}

	@Override
	public Rover getRover() {
		return this.rover;
	}

	@Override
	public void handleLeft(MarsContext c) {
		rover  = c.getRover();
		rover.setFaceString("W");
		c.setRover(rover);
	    c.setState(new WestState(rover));
	}

	@Override
	public void handleMove(MarsContext c) {
		rover  = c.getRover();
		if(rover.getY_value()+1<=rover.getGrid_y()
				&&!MarsUtil.isDupRover(rover.getX_value(),rover.getY_value()+1,rover.getRoverId())){
		rover.setY_value(rover.getY_value()+1);
		c.setRover(rover);
	    c.setState(new NorthState(rover));
		}
		else{
			System.err.println("the rover will go out of the plateau or collide with other Rover");
		}
	}

	@Override
	public void handleRight(MarsContext c) {
		rover = c.getRover();
		rover.setFaceString("E");
		c.setRover(rover);
	    c.setState(new EastState(rover));
	}

}
