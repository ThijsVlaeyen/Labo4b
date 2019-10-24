package domain;

public class PlayerFactory {
    public PlayerFactory (){

    }

    public Player createPlayer(Integer playerId,String name){
        return new Player(playerId,name);
    }
}
