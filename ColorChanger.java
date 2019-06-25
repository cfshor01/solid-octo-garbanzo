package assignment_6;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ColorChanger extends Application {

	private Scene scene;
	private Slider rSlider = new Slider(0,255,0);
	private Slider gSlider = new Slider(0,255,0);
	private Slider bSlider = new Slider(0,255,0);
	private Label label;
	private int red, green, blue;
	private Double r,g,b;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(15);
		grid.setHgap(15);

		rSlider.setShowTickMarks(true);
		rSlider.setOrientation(Orientation.HORIZONTAL);
		
		gSlider.setShowTickMarks(true);
		gSlider.setOrientation(Orientation.HORIZONTAL);

		bSlider.setShowTickMarks(true);
		bSlider.setOrientation(Orientation.HORIZONTAL);
		
		r = rSlider.getValue();
		g = gSlider.getValue();
		b = bSlider.getValue();
		
		red = r.intValue();
		green = g.intValue();
		blue = b.intValue();
		
		label = new Label("CECS 220");	
		Text rt = new Text("Red");
		Text gt = new Text("Green");
		Text bt = new Text("Blue");
		
		grid.setConstraints(label,0,0);
		grid.setConstraints(rt, 0, 1);
		grid.setConstraints(rSlider, 1, 1);
		grid.setConstraints(gt, 0, 2);
		grid.setConstraints(gSlider, 1, 2);
		grid.setConstraints(bt, 0, 3);
		grid.setConstraints(bSlider, 1, 3);
	
		grid.getChildren().addAll(label, rSlider, gSlider, bSlider, rt, gt, bt);
		scene = new Scene(grid, 300, 200);
	
		primaryStage.setScene(scene);
		primaryStage.show();
		
		rSlider.valueProperty().addListener(this::processRChange);
		gSlider.valueProperty().addListener(this::processGChange);
		bSlider.valueProperty().addListener(this::processBChange);

	}
	
	public void processRChange(ObservableValue<? extends Number> property, Number oldValue, Number newValue ) {
		label.setTextFill(Color.rgb(newValue.intValue(), green, blue));
		red = newValue.intValue();
	}
	public void processGChange(ObservableValue<? extends Number> property, Number oldValue, Number newValue ) {
		label.setTextFill(Color.rgb(red, newValue.intValue(), blue));
		green = newValue.intValue();
	}
	public void processBChange(ObservableValue<? extends Number> property, Number oldValue, Number newValue ) {
		label.setTextFill(Color.rgb(red, green, newValue.intValue()));
		blue = newValue.intValue();
	}
}
