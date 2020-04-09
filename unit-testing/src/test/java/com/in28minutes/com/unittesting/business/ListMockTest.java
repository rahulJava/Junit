package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyInt;

public class ListMockTest {
	List mock = Mockito.mock(List.class);
	@Test
	public void basic_test()
	{
	
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	@Test
	public void returnDifferentValues()
	{
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithDiffParameters()
	{
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters()
	{
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}
}
