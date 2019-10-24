package ui;
	
import domain.EventType;
import domain.Game;
import domain.Player;
import domain.PlayerFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new ScoreView();
		Game game = new Game();
		PlayerFactory p = new PlayerFactory();
		game.addPlayer(p.createPlayer(1, "John"));
		game.addPlayer(p.createPlayer(2, "Bob"));
		game.addPlayer(p.createPlayer(3, "Alice"));

		PlayerView pv3 = new PlayerView(3, game);
		PlayerView pv2 = new PlayerView(2, game);
		PlayerView pv1 = new PlayerView(1, game);
		pv1.isCurrentPlayer(true);
		game.addObserver(EventType.ADD,pv1);
		game.addObserver(EventType.ADD,pv2);
		game.addObserver(EventType.ADD,pv3);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
