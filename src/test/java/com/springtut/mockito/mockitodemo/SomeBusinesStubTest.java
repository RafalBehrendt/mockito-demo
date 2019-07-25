package com.springtut.mockito.mockitodemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinesStubTest {

  @Test
  public void findTheGreatestFromAllData(){
    SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(24, result);
  }

  @Test
  public void findTheGreatestFromAllData_OneValue(){
    SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub_OneValue());
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(15, result);
  }

  @Test
  public void findTheGreatestFromAllData_NoValue(){
    SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub_NoValue());
    int result = businessImpl.findTheGreatestFromAllData();
    assertEquals(Integer.MIN_VALUE, result);
  }

}

class DataServiceStub implements DataService{
  @Override
  public int[] retriveAllData() {
    return new int[]{24,6,15};
  }
}


class DataServiceStub_OneValue implements DataService{
  @Override
  public int[] retriveAllData() {
    return new int[]{15};
  }
}


class DataServiceStub_NoValue implements DataService{
  @Override
  public int[] retriveAllData() {
    return new int[]{};
  }

}
