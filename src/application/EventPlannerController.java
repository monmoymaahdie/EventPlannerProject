package application;

import java.util.ArrayList;
import java.util.HashMap;

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
    	menuRow.getChildren().addAll(eventDay,appetizerSelect, mainCourseSelect, dessertSelect);
    	
    	menuSelect.getChildren().addAll(menuSelectTitle, menuRow);
    	
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
    	while (rowCount - 1 < numberOfDays) {
    		HBox menuItemRow = new HBox();
    		
    		//Create labels for each day
    		Label dayLabel = new Label("Day " + rowCount + "");
    		
    		//Create ChoiceBoxes for appetizer, main course, desserts
    		ChoiceBox<String> appetizerOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Appetizer.getAppetizer()));
    		
    		
    		ChoiceBox<String> mainCourseOptions = new ChoiceBox<String>(FXCollections.observableArrayList(MainCourse.getMainCourse()));
    		//mainCourseOptions.getItems().addAll("Placeholder", "Placeholder","Placeholder","Placeholder",
    				//"Placeholder","Placeholder");
    		
    		ChoiceBox<String> dessertOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Dessert.getDessert()));
    		//dessertOptions.getItems().addAll("Placeholder", "Placeholder","Placeholder","Placeholder",
    				//"Placeholder","Placeholder");
    		
    		//Button press to change to scene where user can enter price of items
    		Button addCost = new Button("Enter Cost");
    		
    		
    		addCost.setOnAction(addCostEvent ->{
        		ItemSelected menuItemChosen = new ItemSelected(appetizerOptions.getValue(), mainCourseOptions.getValue(),dessertOptions.getValue());
    			getCostAndPrice(applicationStage.getScene(), menuItemChosen);

    			
    			
    		});
    		
    		menuItemRow.getChildren().addAll(dayLabel, appetizerOptions, mainCourseOptions, dessertOptions, addCost);
    		menuSelect.getChildren().add(menuItemRow);
    		rowCount++;
    	}
    	
    	
    }

	private void getCostAndPrice(Scene scene, ItemSelected menuItems) {
    	Scene mainScene = applicationStage.getScene();
 
		HBox costItems = new HBox();
		
		
		VBox itemContainer = new VBox();
		
		ArrayList<String> items = new ArrayList<String>();
		items.add(menuItems.getAppetizer());
		items.add(menuItems.getMainCourse());
		items.add(menuItems.getDessert());
		
		ArrayList<TextField> costTextFields = new ArrayList<TextField>();
		ArrayList<TextField> priceTextFields = new ArrayList<TextField>();

		int rowCount = 0;
		while (rowCount < items.size()) {

			Label itemLabel = new Label(items.get(rowCount));
			Label costLabel = new Label("Enter Cost Per Serving:");
			TextField costTextField = new TextField();
			costTextFields.add(costTextField);
			Label priceLabel = new Label("Enter Price Per Serving");
			TextField priceTextField = new TextField();
			priceTextFields.add(priceTextField);
			
			itemContainer.getChildren().addAll(itemLabel,costLabel, costTextField,priceLabel,priceTextField);
			rowCount++;

		}
		
		Button doneButton = new Button ("Done!");
		doneButton.setOnAction(doneEvent -> calculateTotalCostAndProfit(mainScene, items, costTextFields, priceTextFields));
		
		costItems.getChildren().addAll(itemContainer, doneButton);
		
	
		//change scene
		Scene costScene = new Scene(costItems);
		applicationStage.setScene(costScene);
	
	
	}


	private void calculateTotalCostAndProfit(Scene menuSelectionScene, ArrayList<String> items,
			ArrayList<TextField> costTextFields, ArrayList<TextField> priceTextFields) {
		
		applicationStage.setScene(menuSelectionScene);
		
			
		HashMap<String, ArrayList<String>> food = new HashMap<String, ArrayList<String>>();
			
			for(int i = 0; i < items.size(); i++) {
				ArrayList<String> stuff = new ArrayList<String>();
				stuff.add(costTextFields.get(i).getText());
				stuff.add(priceTextFields.get(i).getText());
				food.put(items.get(i), stuff);
			}
			
			System.out.println(food);
			
			
			CostTotal budget = new CostTotal();
			
			
			
			
		
		
		
	}

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
    
    

}