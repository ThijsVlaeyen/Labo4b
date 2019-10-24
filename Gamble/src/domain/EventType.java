package domain;

import java.util.ArrayList;
import java.util.List;

public enum EventType {
    ADD(new ArrayList<>()),
    DEPOSIT(new ArrayList<>());

    private List<Observer> observers;

    private EventType(List<Observer> observers){
        this.observers = observers;
    }

    public void addObserver(Observer o){
        this.observers.add(o);
    }

    public List<Observer> getObservers(){
        return this.observers;
    }
}