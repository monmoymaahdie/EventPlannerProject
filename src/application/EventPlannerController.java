package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventPlannerController{
	
	//for new scenes 
	private Stage applicationStage;
	

    @FXML
    private ChoiceBox<Integer> eventDurationChoicebox;
    
    @FXML
    /**
     * Creates a scene to collect information about number of guests and menu selections the user wants 
     * @param event on action of "Start Event: button press in the main event start scene.
     */
    private void startEvent(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	

    	
    	//Changing scene title and adding labels, textfields, and choice boxes.
    	Label guestTitle = new Label("Enter Expected Customers Per Day");
    	
    	int numberOfGuests =  eventDurationChoicebox.getValue();
    	int rowsCreated = 0;
    	
    	VBox guestsContainer = new VBox();
    	//Cresting a list that will put all the textfields with number of guests
    	ArrayList<TextField> guestsTextFields = new ArrayList<TextField>();
    	while (rowsCreated < numberOfGuests) {
		  	rowsCreated++;
    	
	    	HBox rowContainer = new HBox();
		  	Label guestsLabel = new Label("Day " + rowsCreated +" guests ");
		  	TextField guestsTextField = new TextField();
		  	guestsTextFields.add(guestsTextField);
		  	Button menuButton = new Button("Select Menu");
	    	rowContainer.getChildren().addAll(guestsLabel, guestsTextField, menuButton);
		  	
	    	guestsContainer.getChildren().add(rowContainer);
	  }
    
    	Button doneButton = new Button("Done");
	  	//doneButton.setOnAction(doneEvent -> menuSelection(mainScene, guestsTextFields));
	  	guestsContainer.getChildren().add(doneButton);
	  	
	  	Label guestsErrorLabel = new Label();
	  	guestsContainer.getChildren().add(guestsErrorLabel);
	  	
		Scene guestListScene = new Scene(guestsContainer);
		applicationStage.setScene(guestListScene);	
    }
    
    private void menuSelection(Scene menuScene, ArrayList<TextField> guestsTextFields) {
    	
    }

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
    
    

}
