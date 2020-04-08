package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.in28minutes.com.unittesting.BusinessImpl;
import com.in28minutes.com.unittesting.data.SomeDataService;


public class SomeBusinessMockTest 
{
	@Test
	public void calculateSumUsingDataService_basic()
	{
		BusinessImpl business = new BusinessImpl();
		SomeDataService dataService =mock(SomeDataService.class);
		when(dataService.retreiveAllData()).thenReturn(new int[] {1,2,3});
		business.setSomeDataService(dataService);
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
