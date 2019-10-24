package domain;

import java.util.*;

public class Game implements Subject{
    private Map<Integer, Player> players;
    private Map<Player, List<Turn>> turns;
    private Map<EventType, List<Observer>> observers;
    private Dice dice;
    private List<Integer> dices;
    private Queue<Player> playerQueue = new LinkedList<>();
    private List<Turn> listOfTurns;
    private Player currentPlayer;
    private int turnNumber;
    private int previousScore;

    public Game() {
        players = new HashMap<>();
        turns = new HashMap<>();
        observers = new HashMap<>();
        dice = new Dice();
        turnNumber = 0;
        listOfTurns = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        players.put(p.getPlayerId(), p);
        turns.put(p, new ArrayList<Turn>());
        playerQueue.add(p);
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    @Override
    public void addObserver(EventType e, Observer o) {
        if (observers.get(e) == null){
            List<Observer> observers = new ArrayList<>();
            observers.add(o);
            this.observers.put(e,observers);
        }else{
            List<Observer> observers = this.observers.get(e);
            observers.add(o);
        }
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
        currentPlayer = playerQueue.poll();
        if (currentPlayer == null){
            throw new IllegalStateException("something went wrong");
        }
        if (turns.get(currentPlayer).size() < 4){
            int d1 = dice.throwDice();
            int d2 = dice.throwDice();
            Turn t = new Turn(currentPlayer,d1,d2,previousScore);
            turns.get(currentPlayer).add(t);
            previousScore = d1+d2;
            playerQueue.add(currentPlayer);
            Player p2 = playerQueue.peek();
            p2.setCurrent(true);
            setTurn();
            notifyObserver(EventType.ADD, t.toString());
        }else{
            System.out.println("already played 4 rounds - game over");
        }
//        currentPlayer = players.get(playerId);
//        List<Integer> thrownDices = dice.throwDices(2);
//        listOfTurns = turns.get(currentPlayer);
//        if (listOfTurns.size() == 0) previousScore = 0;
//        else previousScore = listOfTurns.get(turnNumber-1).getScore();
//        listOfTurns.add(new Turn(thrownDices.get(0), thrownDices.get(1), previousScore));
//        turns.put(currentPlayer, listOfTurns);
        //turnNumber++;
        //if(turnNumber < 4) endGame();
        //else endGame();
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    private void setTurn() {
        Integer max = Integer.MAX_VALUE;
        for (Map.Entry<Player,List<Turn>> entry :this.turns.entrySet()) {
            if (max>entry.getValue().size()){
                max = entry.getValue().size();
            }
        }
        this.turnNumber = max+1;
    }

    public void endGame() {

    }
}
