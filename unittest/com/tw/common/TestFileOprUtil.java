package com.tw.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFileOprUtil {

	@Test
	public void testReadFileTrue() {
		FileOprUtil.readFile("./file/input/test1.txt");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testReadFilefalse() {
		FileOprUtil.readFile("./file/inputfalse/test1.txt");
		Assert.assertTrue(true);
	}

	@Test
	public void testWriteToFileTrue() {
		FileOprUtil.writeToFile("./file/output/test1.txt", "testtrue");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWriteToFileFalse() {
		FileOprUtil.writeToFile("./file/outputfalse/test1.txt", "testtrue");
		Assert.assertTrue(true);
	}

	@Test
	public void testClearFileTrue() {
		FileOprUtil.clearFile("./file/output/test1.txt");
		Assert.assertTrue(true);
	}

	@Test
	public void testClearFileFalse() {
		FileOprUtil.clearFile("./file/outputfalse/test1.txt");
		Assert.assertTrue(true);
	}
}
