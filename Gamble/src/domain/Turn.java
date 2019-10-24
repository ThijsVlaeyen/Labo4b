package domain;

import java.util.List;

public class Turn {
    private int dice1, dice2, previousScore, score;

    public Turn(int dice1, int dice2, int previousScore) {
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.previousScore = previousScore;
        calculateScore();
    }

    public void calculateScore() {
        score = dice1 + dice2;
        if(dice1 == dice2) score *= 2;
        if(previousScore == score) score +=5;
    }

    public int getScore() {
        return score;
    }
}
