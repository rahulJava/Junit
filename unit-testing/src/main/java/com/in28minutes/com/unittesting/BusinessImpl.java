package com.in28minutes.com.unittesting;

import com.in28minutes.com.unittesting.data.SomeDataService;

public class BusinessImpl {
	
	SomeDataService someDataService;
	
	
	public int calculateSum(int[] data)
	{
		int sum=0;
		for(int value:data)
		{
			sum+=value;
		}
		return sum;
	}
	
	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSumSuingDataService()
	{
		int sum=0;
		int[] data= someDataService.retreiveAllData();
		for(int value: data)
		{
			sum+=value;
		}
		return sum;
	}

}
