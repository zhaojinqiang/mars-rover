package com.tw.impl;

import java.util.Vector;

import com.tw.common.FileOprUtil;
import com.tw.common.MarsUtil;
import com.tw.dto.Rover;
import com.tw.state.EastState;
import com.tw.state.MarsContext;
import com.tw.state.NorthState;
import com.tw.state.SouthState;
import com.tw.state.WestState;

/**
 * class to execute explorer
 * @author zhaojinqiang
 *
 */
public class MarsExplorer {

	/**
	 * exporer method
	 * @param filename
	 */
	public void explorer(String filename){
		MarsUtil.rovers.removeAll(MarsUtil.rovers);
		FileOprUtil.clearFile("../file/output/"+filename+".txt");
		
		Vector<String> vector = FileOprUtil.readFile("../file/input/"+filename+".txt");
		if(vector==null||vector.size()==0){
			return;
		}
		System.out.println("-------------------------------");
		System.out.println("output:");
		//decode
		String p_x_yString =  vector.get(0);
		if(p_x_yString.split(" ").length!=2){
			System.err.println("plateau param is error");
			return;
		}
		int plateau_x = Integer.parseInt(p_x_yString.split(" ")[0]);
		int plateau_y = Integer.parseInt(p_x_yString.split(" ")[1]);
		
		for(int i=1;i<vector.size()-1;i+=2){
			Rover rover = new Rover();
			rover.setGrid_x(plateau_x);
			rover.setGrid_y(plateau_y);
			String positionString = vector.get(i);
			if(positionString.split(" ").length!=3){
				System.err.println("error input: "+positionString);
				break;
			}
			int rover_x = Integer.parseInt(positionString.split(" ")[0]);
			int rover_y = Integer.parseInt(positionString.split(" ")[1]);
			if(rover_x<0||rover_x>plateau_x
					||rover_y<0||rover_y>plateau_y){
				System.err.println("error rover position:rover_x:"+rover_x+"rover_y:"+rover_y);
				return;
			}
			
			String faceString = positionString.split(" ")[2];
			rover.setRoverId(i);
			rover.setX_value(rover_x);
			rover.setY_value(rover_y);
			rover.setFaceString(faceString);
			String instructionsString = vector.get(i+1);
			rover.setInstructionString(instructionsString);
			if(MarsUtil.isDupRover(rover)){
				System.err.println("in input string, duplicate position of rover exists!rover_x:"+rover_x+"rover_y:"+rover_y);
				return;
			}
			MarsUtil.rovers.add(rover);
		}
		
		for(Rover tmpRover:MarsUtil.rovers){
			MarsContext marsContext = new MarsContext();
			marsContext.setRover(tmpRover);
			setCtxState(tmpRover, marsContext);
			executeRoverAction(tmpRover.getInstructionString(), marsContext);
			
			Rover resultRover = marsContext.getRover();
			String result = resultRover.getX_value()+" "+resultRover.getY_value()+" "+resultRover.getFaceString();
			
			System.out.println(result);
			FileOprUtil.writeToFile("../file/output/"+filename+".txt", result);
		}
		System.out.println("-------------------------------");
	}

	/**
	 * execute instruction
	 * L R or M
	 * @param instructionsString
	 * @param marsContext
	 */
	private void executeRoverAction(String instructionsString,
			MarsContext marsContext) {
		//L R M
		for(int j=0;j<instructionsString.length();j++){
			char command = instructionsString.charAt(j);
			if(command=='L'){
				marsContext.left();
			}
			else if(command=='R'){
				marsContext.right();
			}
			else if(command=='M'){
				marsContext.move();
			}
			else{
			     System.err.println("the instructionstring contains error char,command:"+command);
				}
			}//end for
	}

	/**
	 * change state
	 * @param rover
	 * @param marsContext
	 */
	private void setCtxState(Rover rover,
			MarsContext marsContext) {
		String faceString = rover.getFaceString();
		if(faceString.equals("N")){
			marsContext.setState(new NorthState(rover));
		}
		else if(faceString.equals("S")){
			marsContext.setState(new SouthState(rover));
		}
		else if(faceString.equals("W")){
			marsContext.setState(new WestState(rover));
		}
		else if(faceString.equals("E")){
			marsContext.setState(new EastState(rover));
		}
		else{
			//error!
			System.err.println("the faceString is invalid! faceString:"+faceString);
		}
	}
	
}
