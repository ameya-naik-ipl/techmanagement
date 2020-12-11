package edu.ipl.techmanagement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int result = add(2,3);
    	
    	System.out.println("Result of adding 2 & 3 is "+result);
    	
        System.out.println( "Hello World!" );
    }
    
    //Created by Shouradeep
    public static int add(int a, int b) {
    	return a + b;
    }
     
    //Created by Shubham
    public static int subtract(int a, int b) {  
    	
    	return a - b;

    }
    
    //Identifying the various combinations for integrating the 2 methods above and 
    //testing these combinations is called Integration testing
    
    //Integration works at the User Story level and not at Code level
    //Unit test is done at Code level not at User Story level
    
    //In a User Story - the End user functionality is important
    
    //Integration -> System Test -> Acceptance Test is done at User story level
    
    //We can do Integration testing on the UI layer 
    
    
    
    
    
    
}