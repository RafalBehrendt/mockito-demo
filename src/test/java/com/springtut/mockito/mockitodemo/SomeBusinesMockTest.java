package com.springtut.mockito.mockitodemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinesMockTest {

  @Test
  public void findTheGreatestFromAllData(){
    DataService dataServiceMock = mock(DataService.class);

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {24,15,6});

    SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(24, result);
  }

  @Test
  public void findTheGreatestFromAllData_OneValue(){
    DataService dataServiceMock = mock(DataService.class);

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {15});

    SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(15, result);
  }

  @Test
  public void findTheGreatestFromAllData_NoValue(){
    DataService dataServiceMock = mock(DataService.class);

    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});

    SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(Integer.MIN_VALUE, result);
  }

}

