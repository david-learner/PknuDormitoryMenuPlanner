package kr.ac.pknu.dormitory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.HPos;
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
		
		primaryStage.setTitle("ºÎ°æ´ëÇÐ±³ »ýÈ°°ü ½Ä´ÜÇ¥");
		StackPane root = new StackPane();
		GridPane grid = new GridPane();
		
		Label[][] labelArray = new Label[4][8];
		String content = null;
		
		//Class<?> labelClass = Class.forName("javafx.scene.control.Label"); //reflection

		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				content = menuParsingClass.menuPlanner[i][j];
				//labelArray[i][j] = (Label) labelClass.newInstance(); //reflection
				labelArray[i][j] = new Label();
				labelArray[i][j].setText(content);
				GridPane.setConstraints(labelArray[i][j], j, i);
				if(i == 0) {
					GridPane.setHalignment(labelArray[i][j], HPos.CENTER );
					todayDisplay(i, j, labelArray);
				}
				if(j == 0) GridPane.setHalignment(labelArray[i][j], HPos.CENTER );
				
				grid.getChildren().add(labelArray[i][j]);
			}
		}
		root.getChildren().add(grid);
		grid.setHgap(10);
		grid.setVgap(10);
		
		primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
	}
	
	
	//If today is equal to day of week, that day label border appear red color.
	public void todayDisplay(int i, int j, Label[][] labelArray)
	{
		GetToday getToday = new GetToday();
		String today = getToday.GetToday();
		String labelDay = labelArray[i][j].getText();
		Pattern p = Pattern.compile("[^°¡-ÆR^\\(^\\)]");
		Matcher m = p.matcher(labelDay);
		String compareString = "";
		while(m.find())
		{
			compareString += m.group();
		}
		if(compareString.equals(today)) labelArray[i][j].setStyle("-fx-border-color: red;");
	}
}
