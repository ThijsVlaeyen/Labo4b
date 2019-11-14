package ui;

import controller.PlayerController;
import model.Game;
import domain.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView  {
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel; 
	private Button playButton; 
	private Label messageLabel;
	private Game game;
	private PlayerController controller;

	private int playerid;
	
	public PlayerView(PlayerController controller){
		this.controller = controller;
		controller.setView(this);
		this.playerid = controller.getPlayerid();
		diceLabel = new Label("turn 1: ");
		playButton = new Button("throw dice");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		messageLabel = new Label("game not yet started");
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Player "+playerid);
		stage.setResizable(false);		
		stage.setX(100+(playerid-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
	
	public void isCurrentPlayer(boolean turn){
		playButton.setDisable(!turn);
	}

	public void setMessageLabel(String text){
		this.messageLabel.setText(text);
	}

	public void setDiceLabel(String message){
		this.diceLabel.setText(message);
	}


	class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	controller.stepButtonPressed();
        }
    }
}
