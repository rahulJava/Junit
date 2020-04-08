package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.com.unittesting.BusinessImpl;

public class SomeBusinessTest 
{
	@Test
	public void calculateSum_basic()
	{
		BusinessImpl business = new BusinessImpl();
		int actualResult= business.calculateSum(new int[] {1,2,3});
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
		
	}
	@Test
	public void calculateSum_empty()
	{
		BusinessImpl business = new BusinessImpl();
		int actualResult= business.calculateSum(new int[] {});
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
		
	}

}