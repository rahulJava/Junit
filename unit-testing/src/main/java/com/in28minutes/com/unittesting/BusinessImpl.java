package com.in28minutes.com.unittesting;

public class BusinessImpl {
	public int calculateSum(int[] data)
	{
		int sum=0;
		for(int value:data)
		{
			sum+=value;
		}
		return sum;
	}

}
