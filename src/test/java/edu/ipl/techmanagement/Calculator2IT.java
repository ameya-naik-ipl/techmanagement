package edu.ipl.techmanagement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculator2IT {
	
	@Test
	public void testCalculatorIntegrated() {
		
		int a = 10;
		int b = 2;
		
		int actualresult;
		int expectedresult;
		
		System.out.println("Starting Integration test");
		
		actualresult = App.add(a, b);
		expectedresult = 12;
		
		//This line is my verification
		Assert.assertEquals(actualresult, expectedresult);
		
		//Creating a integrated verification below
		int multiplyresult = App2.multiply(actualresult, 5);
		
		Assert.assertEquals(multiplyresult, 60);
		
		System.out.println("Ending Integration test");
		
		
	}
	
	

}
