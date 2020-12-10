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
    
    public static int add(int a, int b) {
    	return a + b;
    }
    
}