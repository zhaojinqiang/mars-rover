package com.tw.state;

import com.tw.dto.Rover;

/**
 * abstract class state
 * @author zhaojinqiang
 *
 */
public abstract class State{
	Rover rover  = null;
	public State(Rover rover){
		this.rover = rover;
	};
	public abstract void handleLeft(MarsContext c);
	public abstract void handleRight(MarsContext c);
	public abstract void handleMove(MarsContext c);
	public abstract Rover getRover();
}