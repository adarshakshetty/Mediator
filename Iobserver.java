package com.example.patient.mediator;

public interface Iobserver {

 public EventType update(EventType eventType,String msg);

}