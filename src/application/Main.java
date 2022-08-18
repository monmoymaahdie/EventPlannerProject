package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


/**
 * Main class for the javafx application for the event planner. It sets up the JavaFx environment
 * and FXMLLoaders to ensure that the first scene and stage are created. This class extends Application.
 * 
 * @author Monmoy
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/EventPlannerView_(scene1).fxml"));
			Scene scene = new Scene(root,434,350);
			
			EventPlannerController selectionController = (EventPlannerController)loader.getController();
			selectionController.setApplicationStage(primaryStage);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Event Planner Application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
