package domain;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Subject{
    private Map<Integer, Player> players;
    private Map<Player, List<Turn>> turns;
    private Map<EventType, List<Observer>> observers;
    private Dice dice;
    List<Integer> dices;
    List<Turn> listOfTurns;
    Player currentPlayer;
    int turnNumber;
    int previousScore;

    public Game() {
        players = new HashMap<Integer, Player>();
        turns = new HashMap<Player, List<Turn>>();
        observers = new HashMap<EventType, List<Observer>>();
        dice = new Dice();
        turnNumber = 0;
        listOfTurns = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        players.put(p.getPlayerId(), p);
        turns.put(p, new ArrayList<Turn>());
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

    public void step(int playerId) {
        currentPlayer = players.get(playerId);
        List<Integer> thrownDices = dice.throwDices(2);
        listOfTurns = turns.get(currentPlayer);
        if (listOfTurns.size() == 0) previousScore = 0;
        else previousScore = listOfTurns.get(turnNumber-1).getScore();
        listOfTurns.add(new Turn(thrownDices.get(0), thrownDices.get(1), previousScore));
        turns.put(currentPlayer, listOfTurns);
        //turnNumber++;
        //if(turnNumber < 4) endGame();
        //else endGame();
    }

    public void endGame() {

    }
}
