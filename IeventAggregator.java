package com.example.patient.mediator;

public interface IeventAggregator {

 public void subScribe(EventType eventType,Iobserver iobserver);

 public void unSubScribe(EventType eventType,Iobserver iobserver);

 public void publish(EventType eventType,String msg);




}