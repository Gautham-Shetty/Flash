package com.uttara.test;

public class ValidationClass {
	
	
	public static boolean validate(String input)
	{
		input=input.trim();
		if(input==null)
		{
			return false;
		}
		else if(input=="")
		{
			return false;
		}
		else
			return true;
		
	
	}
	
	
	
      
}
