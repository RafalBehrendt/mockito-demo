package com.springtut.mockito.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinesMockAnnotationsTest {

  @Mock
  DataService dataServiceMock;

  @InjectMocks
  SomeBusinessImpl businessImpl;

  @Test
  public void findTheGreatestFromAllData(){
    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {24,15,6});
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(24, result);
  }

  @Test
  public void findTheGreatestFromAllData_OneValue(){
    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {15});
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(15, result);
  }

  @Test
  public void findTheGreatestFromAllData_NoValue(){
    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(Integer.MIN_VALUE, result);
  }

}

