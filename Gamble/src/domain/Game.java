package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<Player, List<Turn>> players;

    public Game() {
        players = new HashMap<Player, List<Turn>>();

    }


}
