package com.example.patient.mediator;


public class ObserverC implements Iobserver,EventType {
    private String data;
    private  EventAggregator eventAggregator;
    ObserverA observerA;
    ObserverB observerB;

    public ObserverC(EventAggregator eventAggregator,String data) {
        this.eventAggregator = eventAggregator;
        this.data = data;
    }

    @Override
    public EventType update(EventType eventType, String msg) {
        return eventType.onUpdate();
    }

    @Override
    public EventType onSearchCompleted() {
        return null;
    }

    @Override
    public EventType onItemSelected() {
        return null;
    }

    @Override
    public EventType onUpdate() {
        observerA=new ObserverA(eventAggregator,data);
        observerB=new ObserverB(eventAggregator,data);
        observerB.onUpdate();
        observerA.onUpdate();
        return onUpdate();
    }
}