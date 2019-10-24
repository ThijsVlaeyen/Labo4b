package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Subject{
    private Map<Player, List<Turn>> players;
    private Map<EventType, List<Observer>> observers;

    public Game() {
        players = new HashMap<Player, List<Turn>>();
        observers = new HashMap<EventType, List<Observer>>();
    }

    @Override
    public void addObserver(EventType e, Observer o) {
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(EventType e, Observer o) {
        this.observers.get(e).remove(o);
    }

    @Override
    public void notifyObserver(EventType e, String s) {
        for (Observer o:this.observers.get(e)) {
            o.update(s);
        }
    }

    public void startGame() {
        for (int i=0; i<4; i++) {
            //players
        }
    }
}
