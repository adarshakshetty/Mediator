package com.example.patient.mediator;


public class ObserverB implements Iobserver,EventType {
    private String data;
    private  EventAggregator eventAggregator;
    ObserverC observerC;

    public ObserverB(EventAggregator eventAggregator,String data) {
        this.eventAggregator = eventAggregator;
        this.data = data;
    }
    @Override
    public EventType update(EventType eventType, String msg) {
        return eventType.onItemSelected();
    }

    @Override
    public EventType onSearchCompleted() {
        return null;
    }

    @Override
    public EventType onItemSelected() {
        observerC=new ObserverC(eventAggregator,data);
        observerC.onItemSelected();
        return onItemSelected();
    }

    @Override
    public EventType onUpdate() {
        return null;
    }
}