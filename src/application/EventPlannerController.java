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
	
	int j = 0;
	

	 // HashMap -> HashMap
	 HashMap<Integer, MenuItem> appHash= new HashMap<Integer, MenuItem>();
	 HashMap<Integer, MenuItem> mainHash= new HashMap<Integer, MenuItem>();
	 HashMap<Integer, MenuItem> dessertHash= new HashMap<Integer, MenuItem>();
	

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
    	System.out.println("hello! Testing push agen");
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox menuSelect = new VBox();
    	
    	//Add scene title and ChoiceBoxes for menu items 
    	Label menuSelectTitle = new Label ("Menu Selection for Each Day");
    	menuSelectTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
    	
    	HBox menuRow = new HBox();
    	Label eventDay = new Label("");
    	
    	Label appetizerSelect = new Label("Select Appetizer");
    	
    	
    	Label mainCourseSelect = new Label("Select Main Course");
    	
    	
    	Label dessertSelect = new Label("Select Dessert");
    	
    	
    	menuRow.getChildren().addAll(eventDay,appetizerSelect, mainCourseSelect, dessertSelect);
    	
    	menuSelect.getChildren().addAll(menuSelectTitle, menuRow);
    	
    	// Set Padding
    	menuSelectTitle.setPadding(new Insets(0,0,20,150));
    	appetizerSelect.setPadding(new Insets(10,20,10,80));
    	mainCourseSelect.setPadding(new Insets(10,30,10,50));
    	dessertSelect.setPadding(new Insets(10,40,10,50));
    	
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
    			try {
					getCostAndPrice(applicationStage.getScene(), menuItemChosen);
				} catch (InvalidValueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    			
    			
    		});
    		
    		menuItemRow.getChildren().addAll(dayLabel, appetizerOptions, mainCourseOptions, dessertOptions, addCost);
    		menuSelect.getChildren().add(menuItemRow);
    		rowCount++;
    		
    		//Setting padding
    		HBox.setMargin(dayLabel, new Insets(0,5,10,5)); 
    		HBox.setMargin(appetizerOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(mainCourseOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(dessertOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(addCost, new Insets(0,5,10,5));
    	}
    	
    	
    }

	private void getCostAndPrice(Scene scene, ItemSelected menuItems) throws InvalidValueException {
    	Scene mainScene = applicationStage.getScene();
 
		HBox costItems = new HBox();
		
		
		VBox itemContainer = new VBox();
		
		ArrayList<String> items = new ArrayList<String>();
		items.add(menuItems.getAppetizer());
		items.add(menuItems.getMainCourse());
		items.add(menuItems.getDessert());
		
		ArrayList<String> types = new ArrayList<String>();
		types.add("appetizer");
		types.add("main course");
		types.add("dessert");
		
		ArrayList<TextField> costTextFields = new ArrayList<TextField>();
		ArrayList<TextField> priceTextFields = new ArrayList<TextField>();
		
		ArrayList<MenuItem> itemsMasterList = new ArrayList<MenuItem>();

		int rowCount = 0;
		while (rowCount < items.size()) {
			
			String type = types.get(rowCount);
			Label itemLabel = new Label(items.get(rowCount));
			Label costLabel = new Label("Enter Cost Per Serving:");
			TextField costTextField = new TextField();
			costTextFields.add(costTextField);
			Label priceLabel = new Label("Enter Price Per Serving");
			TextField priceTextField = new TextField();
			priceTextFields.add(priceTextField);
			
			itemContainer.getChildren().addAll(itemLabel,costLabel, costTextField,priceLabel,priceTextField);
			MenuItem menuOption = new MenuItem(items.get(rowCount),type, costTextField.getText(), priceTextField.getText());
			itemsMasterList.add(menuOption);
			rowCount++;
			
			System.out.println(menuOption.getName());

		}
		
		Button doneButton = new Button ("Done!");

		doneButton.setOnAction(doneEvent -> storeTotalCostAndProfit(mainScene, itemsMasterList));
		//doneButton.setOnAction(doneEvent -> calculateTotalCostAndProfit(mainScene, items, costTextFields, priceTextFields));
		
		costItems.getChildren().addAll(itemContainer, doneButton);
		
		
	
		//change scene
		Scene costScene = new Scene(costItems);
		applicationStage.setScene(costScene);
	
	
	}


	private void storeTotalCostAndProfit(Scene menuSelectionScene, ArrayList<MenuItem> list) {
		
		applicationStage.setScene(menuSelectionScene);
		
		String type = "";
		String name = "";
		int num = 0;
		
		//get key for day

		for (int i = 0; i < list.size();i++) {
			if (i % 3 == 0) {
				j++;
			}
			num = i;
			
			type = list.get(i).getType();
		 		
		 	if (type == "appetizer") {
		 		appHash.put(j, list.get(num));
		 	}
			if (type == "main course") {
				mainHash.put(j, list.get(num));
			}
			if (type == "dessert") {
				dessertHash.put(j, list.get(num));
			}
		}
			
		
	
		System.out.println(appHash);
		System.out.println(mainHash);
		System.out.println(dessertHash);
		 	 
		 	 
		 	 
		 	 
	
	}

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
    
    

}