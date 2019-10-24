package ui;
	
import domain.Game;
import domain.Player;
import domain.PlayerFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new ScoreView();
		PlayerView pv3 = new PlayerView(3);
		PlayerView pv2 = new PlayerView(2);
		PlayerView pv1 = new PlayerView(1);		
		pv1.isCurrentPlayer(true);
		Game game = new Game();
		PlayerFactory p = new PlayerFactory();
		game.addPlayer(p.createPlayer(1, "John"));
		game.addPlayer(p.createPlayer(1, "Bob"));
		game.addPlayer(p.createPlayer(1, "Alice"));
		game.startGame();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
