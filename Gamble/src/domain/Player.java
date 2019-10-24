package domain;

public class Player {
    private Integer playerId;
    private String name;
    private Dice dice;
    public boolean isCurrent;

    public Player(Integer playerId,String name){
        this.playerId = playerId;
        this.name = name;
        this.isCurrent = false;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
