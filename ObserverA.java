package com.example.patient.mediator;

public class ObserverA implements Iobserver, EventType {
    private String data;
    private  EventAggregator eventAggregator;
    ObserverB observerB;


    public ObserverA(EventAggregator eventAggregator,String data) {
        this.eventAggregator = eventAggregator;
        this.data = data;
    }

    @Override
    public EventType update(EventType eventType, String msg) {
     return eventType.onSearchCompleted();
    }

    @Override
    public EventType onSearchCompleted() {
        observerB=new ObserverB(eventAggregator,data);
        observerB.onSearchCompleted();
        return onSearchCompleted();
    }

    @Override
    public EventType onItemSelected() {
        return null;
    }

    @Override
    public EventType onUpdate() {
        return null;
    }
}