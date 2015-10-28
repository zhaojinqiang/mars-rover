package com.tw.state;

import com.tw.common.MarsUtil;
import com.tw.dto.Rover;
/**
 * east state class
 * @author zhaojinqiang
 *
 */
public class EastState extends State{

	public EastState(Rover rover) {
		super(rover);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rover getRover() {
		return this.rover;
	}

	@Override
	public void handleLeft(MarsContext c) {
		rover  = c.getRover();
		rover.setFaceString("N");
		c.setRover(rover);
	    c.setState(new NorthState(rover));	
	}

	@Override
	public void handleMove(MarsContext c) {
		rover  = c.getRover();
		if(rover.getX_value()+1<=rover.getGrid_x()
				&&!MarsUtil.isDupRover(rover.getX_value()+1,rover.getY_value(),rover.getRoverId())){
		rover.setX_value(rover.getX_value()+1);
		c.setRover(rover);
	    c.setState(new EastState(rover));
		}
		else{
			System.err.println("the rover will go out of the plateau or collide with other Rover");
		}
	}

	@Override
	public void handleRight(MarsContext c) {
		rover  = c.getRover();
		rover.setFaceString("S");
		c.setRover(rover);
	    c.setState(new SouthState(rover));	
	}

}
