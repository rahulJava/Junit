package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.com.unittesting.BusinessImpl;
import com.in28minutes.com.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService
{

	@Override
	public int[] retreiveAllData() {
		return new int[] {1,2,3};
	}
	
}
class EmptyServiceStub implements SomeDataService
{

	@Override
	public int[] retreiveAllData() {
		return new int[] {};
	}
	
}
public class SomeBusinessStubTest 
{
	@Test
	public void calculateSumUsingDataService_basic()
	{
		BusinessImpl business = new BusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult= business.calculateSumSuingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
		
	}
	@Test
	public void calculateSum_empty()
	{
		BusinessImpl business = new BusinessImpl();
		business.setSomeDataService(new EmptyServiceStub());
		int actualResult= business.calculateSumSuingDataService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
		
	}

}
