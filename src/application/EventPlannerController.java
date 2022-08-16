package application;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
    	
    	//Set padding for each control
    	//https://www.demo2s.com/java/javafx-space-padding-and-margin.html#:~:text=setPadding(new%20Insets(10))%3B,%2C%2010%2C%2020%2C%2010))%3B
    	Label menuSelectTitle = new Label ("Menu Selection for Each Day");
    	menuSelectTitle.setPadding(new Insets(0,0,20,150));
    	menuSelectTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
    	
    	
    	HBox menuRow = new HBox();
    	Label eventDay = new Label("");
    	Label appetizerSelect = new Label("Select Appetizer");
    	appetizerSelect.setPadding(new Insets(10,20,10,80));
    	
    	Label mainCourseSelect = new Label("Select Main Course");
    	mainCourseSelect.setPadding(new Insets(10,30,10,50));
    	
    	Label dessertSelect = new Label("Select Dessert");
    	dessertSelect.setPadding(new Insets(10,40,10,50));
    	
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
    		
    		
    		ChoiceBox<String> dessertOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Dessert.getDessert()));
    		
    		HBox.setMargin(dayLabel, new Insets(0,5,10,5)); 
    		HBox.setMargin(appetizerOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(mainCourseOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(dessertOptions, new Insets(0,5,10,5)); 
    		
    		//Button press to change to scene where user can enter price of items
    		Button addCost = new Button("Enter Cost");
    		HBox.setMargin(addCost, new Insets(0,5,10,5)); 
    		
    		
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
		
			
		//HashMap<String, ArrayList<String>> food = new HashMap<String, ArrayList<String>>();
			
		
		
			//for(int i = 0; i < items.size(); i++) {
				//ArrayList<String> stuff = new ArrayList<String>();
				//stuff.add(costTextFields.get(i).getText());
				//stuff.add(priceTextFields.get(i).getText());
				//food.put(items.get(i), stuff);
			//}
		
			for (int i = 0; i <items.size(); i++) {
				MenuItem appetizer = new MenuItem();

			}
			
			
			
			
			
			
			
		
		
		
	}

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
    
    

}