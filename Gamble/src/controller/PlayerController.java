package controller;

import domain.EventType;
import model.Game;
import domain.Observer;
import ui.PlayerView;

public class PlayerController implements Observer {
    private Game model;
    private PlayerView view;
    private int playerid;

    public PlayerController(int playernm,Game model){
        this.playerid = playernm;
        this.model = model;
        model.addObserver(EventType.PLAYERVIEW,this);
    }

    public void setView(PlayerView view){
        this.view = view;
    }

    public int getPlayerid(){
        return this.playerid;
    }

    @Override
    public void update(String s) {
        if (!model.getCurrentPlayer().equals(this.model.getPlayers().get(this.playerid))) {
			view.setMessageLabel(s);
			boolean current = (model.getPlayers().get(this.playerid).isCurrent());
			view.isCurrentPlayer(current);
		}else{
			view.setDiceLabel("Turn: " + model.getTurnNumber());
			view.setMessageLabel(String.valueOf(this.model.getPlayers().get(this.playerid)));
		}
    }

    public void stepButtonPressed() {
        model.step(this.playerid);
        view.isCurrentPlayer(false);
        model.getPlayers().get(this.playerid).setCurrent(false);
    }
}
