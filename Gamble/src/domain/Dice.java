package domain;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public int throwDice() {
        return (int)(Math.random()*6+1);
    }

    public List<Integer> throwDices(int count) {
        List<Integer> listToReturn = new ArrayList<Integer>();
        listToReturn.add((int) (Math.random()*6+1));
        listToReturn.add((int) (Math.random()*6+1));
        return listToReturn;
    }
}
