package edu.ipl.techmanagement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTestExample {
	
	@Test
	public void test1() {
		System.out.println("This is my first test");
		//Assert.fail("Test Case Failed");
		Assert.assertEquals("1", "1");
		
		
	}

}
