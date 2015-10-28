package com.tw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.tw.impl.MarsExplorer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String choice = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		MarsExplorer marsExplorer = new MarsExplorer();
		do {
			try {
				while (true) {
					printMenu();
					choice = reader.readLine();

					if (choice != null)
						choice = choice.trim();
					else
						break;
					if (choice.equals(""))
						continue;
					else
						break;
				}
				if(choice.startsWith("test")){
					marsExplorer.explorer(choice);
				}
				else if(choice.equalsIgnoreCase("q")){
					break;
				}
				else{
					System.err.println("input error!");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (choice != null);
	}
	
	private static void printMenu() {
		String comment = "++++++++++++++++++++++++++++++++++++++++++++";
		System.out.println(comment);
		System.out.println("++++++++++Mars Rover++++++++++++++++++++");
		System.out.println(comment);
		System.out.println("please input the test file name");
		System.out.println("Notice: filename must starts with 'test',if input q, program will exit!");
		System.out.print("input file name here:");	
	}
}
