package com.tw.dto;

/**
 * Rover Dto class
 * @author zhaojinqiang
 *
 */
public class Rover {

    private int roverId;
	/**
	 * x_value  the left is 0
	 */
	private int x_value;
	/**
	 * y_value the buttom is 0
	 */
	private int y_value;
	/**
	 * faceString 4 types: N S W E
	 */
	private String faceString;
	/**
	 * plateau X
	 */
	private int grid_x;
	/**
	 * plateau Y
	 */
	private int grid_y;
	/**
	 * instructionString
	 */
	private String instructionString;
	
	
	public int getGrid_x() {
		return grid_x;
	}
	public void setGrid_x(int gridX) {
		grid_x = gridX;
	}
	public int getGrid_y() {
		return grid_y;
	}
	public void setGrid_y(int gridY) {
		grid_y = gridY;
	}
	public int getX_value() {
		return x_value;
	}
	public void setX_value(int xValue) {
		x_value = xValue;
	}
	public int getY_value() {
		return y_value;
	}
	public void setY_value(int yValue) {
		y_value = yValue;
	}
	public String getFaceString() {
		return faceString;
	}
	public void setFaceString(String faceString) {
		this.faceString = faceString;
	}
	
	public int getRoverId() {
		return roverId;
	}
	public void setRoverId(int roverId) {
		this.roverId = roverId;
	}
	
	public String getInstructionString() {
		return instructionString;
	}
	public void setInstructionString(String instructionString) {
		this.instructionString = instructionString;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rover [faceString=");
		builder.append(faceString);
		builder.append(", grid_x=");
		builder.append(grid_x);
		builder.append(", grid_y=");
		builder.append(grid_y);
		builder.append(", instructionString=");
		builder.append(instructionString);
		builder.append(", roverId=");
		builder.append(roverId);
		builder.append(", x_value=");
		builder.append(x_value);
		builder.append(", y_value=");
		builder.append(y_value);
		builder.append("]");
		return builder.toString();
	}
	
}
