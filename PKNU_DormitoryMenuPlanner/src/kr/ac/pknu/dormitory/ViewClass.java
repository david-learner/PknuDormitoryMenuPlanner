package kr.ac.pknu.dormitory;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ViewClass extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MenuParsingClass menuParsingClass = new MenuParsingClass();
		
		primaryStage.setTitle("부경대학교 생활관 식단표");
		StackPane root = new StackPane();
		GridPane grid = new GridPane();
		
		Label[] labelArray = new Label[32];
		Label label = new Label();
		String content = null;
		
		for(int i = 0; i < 32; i++)
		{
			content = menuParsingClass.menuPlanner[i];
			System.out.println(content);
			labelArray[i].setText(content);
			for(int j = 0; j < 4; j++)
			{
				GridPane.setConstraints(label, j, i%8);
			}
			grid.getChildren().addAll(labelArray);
		}
		root.getChildren().add(grid);
		primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
	}
}
