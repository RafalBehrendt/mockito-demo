package com.springtut.mockito.mockitodemo;

public class SomeBusinessImpl {
  private DataService dataService;

  public SomeBusinessImpl(DataService dataService){
    this.dataService = dataService;
  }

  int findTheGreatestFromAllData(){
    int[] data = dataService.retriveAllData();
    int greatest = Integer.MIN_VALUE;

    for(int value : data){
      if(value > greatest){
        greatest = value;
      }
    }
    return greatest;
  }
}
