package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	private Stage applicationStage;
	private Appetizer appChoices = new Appetizer();
	private MainCourse mainChoices = new MainCourse();
	private Dessert dessertChoices = new Dessert();
	
	

    @FXML
    private ChoiceBox<Integer> eventDurationChoicebox;
    
    @FXML
    private TextField guestsTextField;
    
    @FXML
    /**
     * Creates a scene to collect information about number of guests and menu selections the user wants 
     * @param event on action of "Start Event: button press in the main event start scene.
     */
    private void startEvent(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox menuSelect = new VBox();
    	
    	//Add scene title and ChoiceBoxes for menu items 
    	Label menuSelectTitle = new Label ("Menu Selection for Each Day");
    	HBox menuRow = new HBox();
    	Label eventDay = new Label("");
    	Label appetizerSelect = new Label("Select Appetizer");
    	Label mainCourseSelect = new Label("Select Main Course");
    	Label dessertSelect = new Label("Select Dessert");
    	menuRow.getChildren().addAll(appetizerSelect, mainCourseSelect, dessertSelect);
    	
    	menuSelect.getChildren().addAll(menuRow);
    	
    	//Error Label
    	Label errorMessage = new Label ("");
    	
    	//Select Menu Items 
    	menuSelection(menuSelect, errorMessage);

    	//set the new scene
    	Scene menuSelectionScene = new Scene(menuSelect);
    	applicationStage.setScene(menuSelectionScene);

 
    }
    
    private void menuSelection(VBox menuSelect, Label errorLabel) {
    	//while loop to create labels, ChoiceBoxes, and button
    	int numberOfDays = eventDurationChoicebox.getValue();
    	int rowCount = 1;
    	while (rowCount < numberOfDays) {
    		HBox menuItemRow = new HBox();
    		
    		//Create labels for each day
    		Label dayLabel = new Label("Day " + rowCount + "");
    		
    		//Create ChoiceBoxes for appetizer, main course, desserts
    		ChoiceBox<String> appetizerOptions = new ChoiceBox<String>();
    		appetizerOptions.getItems().addAll("Placeholder", "Placeholder","Placeholder","Placeholder",
    				"Placeholder","Placeholder");
    		
    		ChoiceBox<String> mainCourseOptions = new ChoiceBox<String>();
    		mainCourseOptions.getItems().addAll("Placeholder", "Placeholder","Placeholder","Placeholder",
    				"Placeholder","Placeholder");
    		
    		ChoiceBox<String> dessertOptions = new ChoiceBox<String>();
    		dessertOptions.getItems().addAll("Placeholder", "Placeholder","Placeholder","Placeholder",
    				"Placeholder","Placeholder");
    		
    		//Button press to change to scene where user can enter price of items
    		Button addCost = new Button("Add Cost");
    		
    		
    		addCost.setOnAction(addCostEvent ->{
        		ItemSelected menuItemChosen = new ItemSelected(appetizerOptions.getValue(), mainCourseOptions.getValue(),dessertOptions.getValue());
    			getCost(applicationStage.getScene(), menuItemChosen);

    			
    			
    		});
    		
    		menuItemRow.getChildren().addAll(dayLabel, appetizerOptions, mainCourseOptions, dessertOptions, addCost);
    		menuSelect.getChildren().add(menuItemRow);
    		rowCount++;
    	}
    	
    	
    }

	private void getCost(Scene scene, ItemSelected menuItems) {
		VBox costItems = new VBox();
		
		
		HBox appContainer = new HBox();
		//for appetizers
		Label appetizerLabel = new Label(menuItems.getAppetizer());
		TextField appetizerCostTextField = new TextField();
		TextField appetizerInventoryTextField = new TextField();
		
		appContainer.getChildren().addAll(appetizerLabel,appetizerCostTextField, appetizerInventoryTextField);

		HBox mainCourseContainer = new HBox();
		//for mainCourse
		Label mainCourseLabel = new Label(menuItems.getMainCourse());
		TextField mainCourseCostTextField = new TextField();
		TextField mainCourseInventoryTextField = new TextField();
		
		mainCourseContainer.getChildren().addAll(mainCourseLabel,mainCourseCostTextField, mainCourseInventoryTextField);
		
		HBox dessertContainer = new HBox();
		//for mainCourse
		Label dessertLabel = new Label(menuItems.getMainCourse());
		TextField dessertCostTextField = new TextField();
		TextField dessertInventoryTextField = new TextField();
		
		dessertContainer.getChildren().addAll(dessertLabel,dessertCostTextField, dessertInventoryTextField);
		
		costItems.getChildren().addAll(appContainer, mainCourseContainer, dessertContainer);
	
		//change scene
		Scene costScene = new Scene(costItems);
		applicationStage.setScene(costScene);
	
	
	}

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
    
    

}
