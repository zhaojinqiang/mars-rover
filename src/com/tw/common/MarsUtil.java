package com.tw.common;

import java.util.LinkedList;
import java.util.List;

import com.tw.dto.Rover;

/**
 * mars util class
 * @author zhaojinqiang
 *
 */
public class MarsUtil {

	/**
	 * all rovers in plateau
	 */
	public static List<Rover> rovers = new LinkedList<Rover>();
	
	/**
	 * check if duplicate rover exists
	 * @param rover
	 * @return
	 */
	public static boolean isDupRover(Rover rover){
		boolean flag=false;
		for(Rover idxrover:MarsUtil.rovers){
			if(idxrover.getX_value()==rover.getX_value()
					&&idxrover.getY_value()==rover.getY_value()
					&&idxrover.getRoverId()!=rover.getRoverId()){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public static boolean isDupRover(int x,int y,int id){
		boolean flag=false;
		for(Rover idxrover:MarsUtil.rovers){
			if(idxrover.getX_value()==x
					&&idxrover.getY_value()==y
					&&idxrover.getRoverId()!=id){
				flag=true;
				break;
			}
		}
		return flag;
	}
}
