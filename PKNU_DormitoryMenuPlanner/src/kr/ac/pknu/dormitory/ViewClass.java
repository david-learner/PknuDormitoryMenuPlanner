package kr.ac.pknu.dormitory;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ViewClass extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("부경대학교 생활관 식단표");
		Label label1 = new Label();
		StackPane root = new StackPane();
		label1.setText("부경대학교 생활관 식단표");
        root.getChildren().add(label1);
		primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
	}
}
