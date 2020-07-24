package com.example.patient.mediator;

import java.util.ArrayList;
import java.util.Iterator;

public class EventAggregator implements IeventAggregator {

    ArrayList<Iobserver>  iobserverArrayList;
    ArrayList<EventType>  eventTypeArrayList;


    public EventAggregator() {
        iobserverArrayList=new ArrayList<Iobserver>();
        eventTypeArrayList=new ArrayList<EventType>();
    }

    @Override
    public void subScribe(EventType eventType,Iobserver iobserver) {
        eventTypeArrayList.add(eventType);
        iobserverArrayList.add(iobserver);
    }

    @Override
    public void unSubScribe(EventType eventType,Iobserver iobserver) {
        eventTypeArrayList.remove(eventType);
        iobserverArrayList.remove(iobserver);
    }


    @Override
    public void publish(EventType eventType,String data) {
        Iterator<Iobserver> iterator= iobserverArrayList.iterator();
        while(iterator.hasNext()){
            Iobserver iobserver=iterator.next();
            iobserver.update(eventType,data);
        }
    }


}