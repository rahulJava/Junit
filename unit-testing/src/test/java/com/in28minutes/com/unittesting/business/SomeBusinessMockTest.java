package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.com.unittesting.BusinessImpl;
import com.in28minutes.com.unittesting.data.SomeDataService;


@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest 
{
	
	@InjectMocks
	BusinessImpl business ;
	
	@Mock
	SomeDataService dataService ;
	
//	@BeforeEach
//	public void before()
//	{
//		business.setSomeDataService(dataService);
//	}
	@Test
	public void calculateSumUsingDataService_basic()
	{
		when(dataService.retreiveAllData()).thenReturn(new int[] {1,2,3});
		
		int actualResult= business.calculateSumSuingDataService();
		assertEquals(6, actualResult);
		
	}
	@Test
	public void calculateSum_empty()
	{
		
		when(dataService.retreiveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumSuingDataService());
		
	}
	@Test
	public void calculateSum_5()
	{
		when(dataService.retreiveAllData()).thenReturn(new int[] {5});
		int actualResult= business.calculateSumSuingDataService();
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
		
	}

}
