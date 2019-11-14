package ui;

import controller.ScoreController;
import domain.Observer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreView {
	private Stage stage = new Stage();
	private Scene scoreScene;
	private Label scoreLabel;
	private ScoreController controller;
		
	public ScoreView(ScoreController controller){
		this.controller = controller;
		controller.setView(this	);
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");
		layoutComponents();
		stage.setScene(scoreScene);
		stage.setTitle("Overzicht scores");
		stage.setResizable(false);		
		stage.setX(100);
		stage.setY(400);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox();
		scoreScene = new Scene(root,400,200);
		root.getChildren().add(scoreLabel);
	}
	
	public void addScoreLine(String scoreLijn){
		scoreLabel.setText(scoreLabel.getText()+"\n"+scoreLijn);
	}
}
