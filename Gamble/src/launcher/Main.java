package launcher;
	
import controller.PlayerController;
import controller.ScoreController;
import domain.Player;
import domain.PlayerFactory;
import model.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.PlayerView;
import ui.ScoreView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Game model = new Game();
		PlayerController playerController1 = new PlayerController(1,model);
		PlayerController playerController2 = new PlayerController(2,model);
		PlayerController playerController3 = new PlayerController(3,model);
		ScoreController scoreController = new ScoreController(model);
		PlayerView playerView1 = new PlayerView(playerController1);
		PlayerView playerView2 = new PlayerView(playerController2);
		PlayerView playerView3 = new PlayerView(playerController3);
		ScoreView scoreView = new ScoreView(scoreController);
		PlayerFactory p = new PlayerFactory();
		model.addPlayer(p.createPlayer(1, "John"));
		model.addPlayer(p.createPlayer(2, "Bob"));
		model.addPlayer(p.createPlayer(3, "Alice"));
		playerView1.isCurrentPlayer(true);

//		ScoreView sc = new  ScoreView();
//		Game game = new Game();


//
//		PlayerView pv3 = new PlayerView(3, game);
//		PlayerView pv2 = new PlayerView(2, game);
//		PlayerView pv1 = new PlayerView(1, game);
//		pv1.isCurrentPlayer(true);
//		game.addObserver(EventType.PLAYERVIEW,pv1);
//		game.addObserver(EventType.PLAYERVIEW,pv2);
//		game.addObserver(EventType.PLAYERVIEW,pv3);
//		game.addObserver(EventType.SCOREVIEW,sc);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
