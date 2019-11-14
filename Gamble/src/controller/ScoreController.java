package controller;

import domain.EventType;
import model.Game;
import domain.Observer;
import ui.ScoreView;

public class ScoreController implements Observer {
    private Game model;
    private ScoreView view;

    public ScoreController(Game model){
        this.model = model;
        model.addObserver(EventType.SCOREVIEW,this);
    }

    public void setView(ScoreView view){
        this.view = view;
    }

    @Override
    public void update(String s) {
        view.addScoreLine(model.getScoreViewString());
    }
}
