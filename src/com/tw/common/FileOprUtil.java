package com.tw.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
/**
 * file operation class
 * @author zhaojinqiang
 *
 */
public class FileOprUtil {

	/**
	 * read input from file
	 * @param filepathString
	 * @return
	 */
	public static Vector<String> readFile(String filepathString){
		BufferedReader reader = null;
		Vector<String> vector = new Vector<String>();
		File testFile = new File(filepathString);
		if(testFile.isFile()&&testFile.exists()){
			try {
				reader = new BufferedReader(new FileReader(testFile));
				String line = null;
				System.out.println("input:");
				while((line = reader.readLine()) != null){
					System.out.println(line);
					vector.add(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try{ reader.close(); }catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else{
			System.err.println("the file to read is not exist!");
		}
		return vector;
	}
	
	/**
	 * write the result to the output file
	 * @param filepathString
	 * @param result
	 */
	public static void writeToFile(String filepathString,String result){
		File testFile = new File(filepathString);
		FileWriter fileWriter = null;
		if(testFile.isFile()&&testFile.exists()){
			try {
				fileWriter = new FileWriter(testFile,true);
				fileWriter.write(result+"\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try{ fileWriter.close(); }catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			System.err.println("the file to write is not exist!");
		}
		
	}
	
	/**
	 * clear the file content
	 * @param filepathString
	 */
	public static void clearFile(String filepathString){
		File testFile = new File(filepathString);
		FileWriter fileWriter = null;
		if(testFile.isFile()&&testFile.exists()){
			try {
				fileWriter = new FileWriter(testFile);
				fileWriter.write("");
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try{ fileWriter.close(); }catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			System.err.println("the file to clear is not exist!");
		}
		
	}
}
