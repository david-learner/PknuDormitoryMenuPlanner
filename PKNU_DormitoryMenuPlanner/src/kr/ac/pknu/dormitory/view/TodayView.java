package kr.ac.pknu.dormitory.view;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kr.ac.pknu.dormitory.GetNow;
import kr.ac.pknu.dormitory.util.DateTime;

public class TodayView extends Application {
	
	WeekView weekView = new WeekView();

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		HBox buttonBar = new HBox();
		Button breakfastBtn = new Button("아침");
		Button lunchBtn  = new Button("점심");
		Button dinnerBtn = new Button("저녁");
		Label label = new Label();
		String breakfastStr, lunchStr, dinnerStr;
		
		/* init */
		//label.setText("menuContent");
		breakfastStr = weekView.getBreakfast();
		lunchStr = weekView.getLunch();
		dinnerStr = weekView.getDinner();

		/* button action */
		breakfastBtn.setOnAction(e->label.setText(breakfastStr));
		lunchBtn.setOnAction(e->label.setText(lunchStr));
		dinnerBtn.setOnAction(e->label.setText(dinnerStr));
		
		int i = DateTime.getNow();
		switch(i) {
			case 1 : label.setText(breakfastStr); break;
			case 2 : label.setText(lunchStr); break;
			case 3 : label.setText(dinnerStr); break;
		}
			
		/* buttonBar design */
		double hSpacing = 10;
		buttonBar.setSpacing(hSpacing);
		buttonBar.getChildren().addAll(breakfastBtn, lunchBtn, dinnerBtn);
		
		root.getChildren().addAll(buttonBar, label);
		Scene rootScene = new Scene(root, 150, 200);
		
		primaryStage.setScene(rootScene);
		primaryStage.show();
	}	
}
