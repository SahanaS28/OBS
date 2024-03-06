package mavenproject;

import org.testng.annotations.Test;



public class sampleTest 
{
	@Test(groups="regression")
	public void demo1()
	{
		System.out.println("1");
	}
	
	@Test(groups="smoke")
	public void pen1()
	{
		System.out.println("2");
	}
	
	

	
}
