package com.example.patient.mediator;

public class MainClass {

 public static void main(String[] args)
 {


  EventAggregator eventAggregator=new EventAggregator();


  ObserverA observerA=new ObserverA(eventAggregator,"HI");
  ObserverB observerB=new ObserverB(eventAggregator,"HI");
  ObserverC observerC=new ObserverC(eventAggregator,"HI");

  eventAggregator.subScribe(observerA.onSearchCompleted(),observerA);
  eventAggregator.subScribe(observerB.onItemSelected(),observerB);
  eventAggregator.subScribe(observerC.onUpdate(),observerC);

  //Publish A
  eventAggregator.publish(observerA.onSearchCompleted(),"onSearch completed");

  eventAggregator.unSubScribe(observerA.onSearchCompleted(),observerA);


  //Publish B
  eventAggregator.publish(observerB.onItemSelected(),"onItemSelected ");

  eventAggregator.unSubScribe(observerB.onItemSelected(),observerB);


  //Publish C
  eventAggregator.publish(observerC.onUpdate(),"onItemSelected ");

  eventAggregator.unSubScribe(observerC.onUpdate(),observerC);


 }


}


