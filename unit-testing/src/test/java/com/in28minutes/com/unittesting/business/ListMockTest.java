package com.in28minutes.com.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {
	List<String> mock = Mockito.mock(List.class);
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
	
	@Test
	public void verificationBasics()
	{//verify get method i called on mock
		String value= mock.get(0);
		String value2 = mock.get(1);
		// by default verify check for only one time
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,never()).get(2);
	}
	@Test
	public void arguementCapturing()
	{
		mock.add("someString");
		mock.add("someString1");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues= captor.getAllValues();
		assertEquals("someString", allValues.get(0));
		assertEquals("someString1",allValues.get(1));
	}
	
	//@Test
	public void mocking()
	{
		ArrayList arrayList = Mockito.mock(ArrayList.class);
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.size());
		System.out.println(arrayList.add("Test"));
		System.out.println(arrayList.add("Test2"));
		arrayList.size();
		System.out.println(arrayList.size());
		when(arrayList.size()).thenReturn(5);
		System.out.println(arrayList.size());
	}
	
	@Test
	public void spying()
	{
		ArrayList arrayList = Mockito.spy(ArrayList.class);
		arrayList.add("Test0");
		System.out.println(arrayList.get(0));
		System.out.println("1::"+arrayList.size());
		System.out.println(arrayList.add("Test"));
		System.out.println(arrayList.add("Test2"));
		arrayList.size();
		System.out.println(arrayList.size());
		when(arrayList.size()).thenReturn(5);
		System.out.println(arrayList.size());
		verify(arrayList).add("Test0");
	}
}
