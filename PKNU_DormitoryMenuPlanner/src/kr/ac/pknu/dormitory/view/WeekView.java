package kr.ac.pknu.dormitory.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.ac.pknu.dormitory.GetNow;
import kr.ac.pknu.dormitory.MenuParsingClass;
import kr.ac.pknu.dormitory.util.DateTime;

public class WeekView extends Application {

	private Label[][] labelArray = new Label[4][8];
	public static String breakfast, lunch, dinner;
	int todayRowIndex, todayColumnIndex;
	int rowIndex = 0, columnIndex = 0;
	boolean toggle = true;
	private static double xOffset = 0;
	private static double yOffset = 0;
	// public static void main(String[] args) {
	// launch(args);
	// }
	
	private void fillLabel(Stage primaryStage) throws Exception {
		MenuParsingClass menuParsingClass = new MenuParsingClass();
		VBox verticalBox = new VBox();
		StackPane root = new StackPane();
		GridPane grid = new GridPane();
		
		String content;

		// Class<?> labelClass = Class.forName("javafx.scene.control.Label");
		// reflection
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				content = menuParsingClass.menuPlanner[i][j];
				// labelArray[i][j] = (Label) labelClass.newInstance();
				// //reflection
				labelArray[i][j] = new Label();
				labelArray[i][j].setText(content);
				GridPane.setConstraints(labelArray[i][j], j, i); // �� ������ �־�� ����
																	// ������ �����ϴ�?
				if (i == 0) {
					GridPane.setHalignment(labelArray[i][j], HPos.CENTER);
					dateDisplay(i, j, labelArray);
				}
				if (j == 0)
					GridPane.setHalignment(labelArray[i][j], HPos.CENTER);

				grid.getChildren().add(labelArray[i][j]);
			}
		}

		breakfast = labelArray[1][todayColumnIndex].getText();
		lunch = labelArray[2][todayColumnIndex].getText();
		dinner = labelArray[3][todayColumnIndex].getText();

		/**
		 * Make the buttons.
		 */

		// Button windowToggleButton = new Button("ũ������");
		//
		// windowToggleButton.setOnAction(e -> {
		// if(toggle){
		// windowToggleButton.setText("ũ������");
		// primaryStage.hide();
		// primaryStage.initStyle(StageStyle.DECORATED);
		// primaryStage.show();
		// toggle = !toggle;
		// }else {
		// windowToggleButton.setText("ũ�����");
		// primaryStage.hide();
		// primaryStage.initStyle(StageStyle.TRANSPARENT);
		// primaryStage.show();
		// toggle = !toggle;
		// }
		// });

		// for�ȿ��� ��..���� ���?�� �� �� ���� �̿��Ϸ��� �ϸ� null exception ������ ���.
		// for���� ����� ��� ���� ����� �Ϸ�� �����̹Ƿ� �׸����� ��� ���� ���� ������ �����Ӵ�.
		timeDisplay();
		// verticalBox.getChildren().add(windowToggleButton);
		verticalBox.getChildren().add(grid);
		root.getChildren().add(verticalBox);

		// root.setAlignment(grid, Pos.CENTER); //�Ű������� node�� ���� setAlignment��
		// static�޼ҵ��. root�� ���ָ� ���� ��?
		// StackPane.setAlignment(grid, Pos.CENTER_RIGHT);
		grid.setAlignment(Pos.CENTER); // StackPane���� �ö��ִ� grid�� ����� �����Ѵ�.
		grid.setHgap(10);
		grid.setVgap(10);
		// VBox�� �������� �ش�. Insets��ü�� ���� �˾ƺ���.
		// VBox.setMargin(root, new Insets(10, 10, 10, 10));
		VBox.setMargin(grid, new Insets(30, 10, 15, 10));

		// primaryStage.setScene(new Scene(root, 900, 400));
		Scene rootScene = new Scene(root, 900, 400);
		rootScene.setFill(Color.TRANSPARENT);
		// grid.setStyle("-fx-border-color: burlywood");

		/* Background Color with transparent */
		root.setStyle("-fx-background-color: rgba(252, 228, 236, 0.7);");
		// primaryStage.setTitle("�ΰ���б� ��Ȱ�� �Ĵ�ǥ");
		// primaryStage.initStyle(StageStyle.UNDECORATED);

		rootScene.setOnMousePressed(e -> {
			xOffset = primaryStage.getX() - e.getScreenX();
			yOffset = primaryStage.getY() - e.getScreenY();
			System.out.println(
					"xOffset : " + xOffset + "stageX : " + primaryStage.getX() + "   Screen X : " + e.getScreenX());
			System.out.println(
					"yOffset : " + yOffset + "stageY : " + primaryStage.getY() + "   Screen Y : " + e.getScreenY());
		});

		rootScene.setOnMouseDragged(e -> {
			primaryStage.setX(e.getScreenX() + xOffset);
			primaryStage.setY(e.getScreenY() + yOffset);
			System.out.println("ScreenX : " + e.getSceneX() + "  ScreenY : " + e.getScreenY());

		});

		// DragResizer dragResizer = new DragResizer((Region)rootScene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(rootScene);
		

		// ���α׷��� ����� �����ϰ� ������� Stage, Scene, Pane�� �����ϰ� �������� �Ѵ�.
		// �� �� Stage�� Scene�� setStyle()�� �������� �ʰ� Stage�� initStyle(), Scene��
		// setFill()�� ���Ͽ� �����ϰ� ���� �� �ִ�.

		Stage secondStage = new Stage();
		TodayView todayView = new TodayView();
		todayView.start(secondStage);
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		fillLabel(primaryStage);
	}

	// If today is equal to day of week, that day label border appear red color.
	public void dateDisplay(int i, int j, Label[][] labelArray) {
		GetNow getDate = new GetNow();
		String date = getDate.date();
		String labelDay = labelArray[i][j].getText();
		Pattern p = Pattern.compile("[^��-�R^\\(^\\)]"); // Regular Expression
														// ��(1/17) -> 1/17
		// System.out.println(labelDay);
		Matcher m = p.matcher(labelDay);
		String compareString = "";
		System.out.println(date);
		while (m.find()) {
			compareString += m.group();
		}

		/* Find the matched date for red border */
		if (compareString.equals(date)) {
			System.out.println("i : " + i + " j : " + j);
			labelArray[i][j].setStyle("-fx-border-color: red;");
			rowIndex = i;
			columnIndex = j;
			todayColumnIndex = j;
		} else {
			System.out.println("Date is wrong");
			System.out.println("i : " + i + " j : " + j);
		}
	}

	/**
	 * if I find date matched today, I will call timeDisplay method in
	 * dateDisplay.
	 */
	public void timeDisplay() {
		int i = DateTime.getNow();
		switch(i) {
			case 1 : labelArray[1][columnIndex].setStyle("-fx-border-color: red;"); break;
			case 2 : labelArray[2][columnIndex].setStyle("-fx-border-color: red;"); break;
			case 3 : labelArray[3][columnIndex].setStyle("-fx-border-color: red;"); break;
		}
	}

	public String getBreakfast() {
		return breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public String getDinner() {
		return dinner;
	}
}
