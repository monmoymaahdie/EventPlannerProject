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

	
	private int j = 0;
	

	 // HashMap -> HashMap
	 private HashMap<Integer, MenuItem> appHash= new HashMap<Integer, MenuItem>();
	 private HashMap<Integer, MenuItem> mainHash= new HashMap<Integer, MenuItem>();
	 private HashMap<Integer, MenuItem> dessertHash= new HashMap<Integer, MenuItem>();
	

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
    		
    		ChoiceBox<String> dessertOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Dessert.getDessert()));
    	
    		
    		
    		
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
    	
    	HBox buttons = new HBox();
    	Button calculateTotalButton = new Button("Calculate Total");
    	Button endButton = new Button("Event Summary");
    	calculateTotalButton.setOnAction(calculateEvent -> calculateTotal(menuSelect, appHash, mainHash, dessertHash,endButton));
    	
    	buttons.getChildren().addAll(calculateTotalButton,endButton);
    	
    	menuSelect.getChildren().addAll(buttons);
    }


	private void calculateTotal(VBox mainScene, HashMap<Integer, MenuItem> appHash2,
			HashMap<Integer, MenuItem> mainHash2, HashMap<Integer, MenuItem> dessertHash2, Button button) {

		int numberOfDays = eventDurationChoicebox.getValue();
		
		Value guests = new Value(0,200,5);
		guests.setValue(guestsTextField.getText());
		
		double appetizerTotalCost = 0.0;
		double mainCourseTotalCost = 0.0;
		double dessertTotalCost = 0.0;
		
		double appetizerTotalRevenue = 0.0;
		double mainCourseTotalRevenue = 0.0;
		double dessertTotalRevenue = 0.0;
		//for appetizer
		for(int i = 1; i < appHash.size()+1; i++) {
			appetizerTotalCost += appHash.get(i).getCost();
			mainCourseTotalCost += mainHash.get(i).getCost();
			dessertTotalCost += dessertHash.get(i).getCost();
			
			appetizerTotalRevenue += appHash.get(i).getPrice();
			mainCourseTotalRevenue += mainHash.get(i).getPrice();
			dessertTotalRevenue += dessertHash.get(i).getPrice();		
			
		}
		
		System.out.println(appHash.get(1).getPrice());
		System.out.println(appetizerTotalRevenue);
		
		
		Cost costBreakdown = new Cost(appetizerTotalCost, mainCourseTotalCost, dessertTotalCost, guests.getAmount());
		Revenue priceBreakdown = new Revenue(appetizerTotalRevenue, mainCourseTotalRevenue, dessertTotalRevenue, guests.getAmount());
		
		System.out.println("app" + appetizerTotalCost);
		System.out.println("main" + mainCourseTotalCost);
		System.out.println("dessert" + dessertTotalCost);
		
		ProfitLoss result = new ProfitLoss(costBreakdown.getEventTotalCost(),priceBreakdown.getEventTotalPrice());
		
		
		button.setOnAction(endEvent -> eventSummaryPage(applicationStage.getScene(), costBreakdown, priceBreakdown, result));
		
	
	}

	private void eventSummaryPage(Scene scene, Cost costBreakdown, Revenue priceBreakdown, ProfitLoss result) {
		
		VBox mainBox = new VBox();
		
		Label summaryTitle = new Label("Event Summary Page");
		
		
		VBox textBox = new VBox();
		
		Label eventTotalCost = new Label("Your total cost for this event is: " + String.valueOf(costBreakdown.getEventTotalCost()));
		Label eventTotalRevenue = new Label("Your total revenue for this event is:" + String.valueOf(priceBreakdown.getEventTotalPrice()));
		Label profitOrLoss = new Label(result.checkProfitOrLoss());
		Label resultAmount = new Label(result.findAmount());
		
		//padding
		VBox.setMargin(summaryTitle, new Insets(10,30,10,30)); 
		VBox.setMargin(eventTotalCost, new Insets(5,30,10,30)); 
		VBox.setMargin(eventTotalRevenue, new Insets(5,30,10,30)); 
		VBox.setMargin(profitOrLoss, new Insets(5,30,10,30)); 
		VBox.setMargin(resultAmount, new Insets(5,30,30,30)); 
		
		//font
		summaryTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30)); 
		eventTotalCost.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		eventTotalRevenue.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		profitOrLoss.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		resultAmount.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		
		
		
		textBox.getChildren().addAll(eventTotalCost, eventTotalRevenue, profitOrLoss, resultAmount);
		mainBox.getChildren().addAll(summaryTitle, textBox);
		
		Scene summaryScene = new Scene(mainBox);
		applicationStage.setScene(summaryScene);
		
	}
	
	

	private void getCostAndPrice(Scene scene, ItemSelected menuItems) throws InvalidValueException {
    	Scene mainScene = applicationStage.getScene();
 
		VBox costItems = new VBox();
			
		Label errorLabel = new Label("Enter cost and price of each item.");

		
		
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
		
		
		int rowCount = 0;
		while (rowCount < items.size()) {
			HBox itemContainer = new HBox();

			Label itemLabel = new Label(items.get(rowCount));
			rowCount++;

			Label costLabel = new Label("Cost: $");
			TextField costTextField = new TextField();
			costTextFields.add(costTextField);
			Label priceLabel = new Label("Price: $");
			TextField priceTextField = new TextField();
			priceTextFields.add(priceTextField);
			
			itemLabel.setPadding(new Insets(5,10,20,10));
			costLabel.setPadding(new Insets(5,10,20,50));
			costTextField.setPadding(new Insets(5,0,5,0));
			priceLabel.setPadding(new Insets(5,30,10,50));
			priceTextField.setPadding(new Insets(5,0,5,0));
			
			itemLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 12)); 

			
			itemContainer.getChildren().addAll(itemLabel,costLabel, costTextField,priceLabel,priceTextField);
			costItems.getChildren().addAll(itemContainer);

			
		}
			
		
		Button doneButton = new Button ("Add Values to Directory!");
		doneButton.setOnAction(doneEvent -> setCostandPrice(mainScene,errorLabel, items, types, costTextFields, priceTextFields));
		
		costItems.getChildren().addAll(doneButton, errorLabel);
		
		
	
		//change scene
		Scene costScene = new Scene(costItems);
		applicationStage.setScene(costScene);
	
	
	}
	
	private void setCostandPrice(Scene mainScene, Label valueErrorLabel, ArrayList<String> items, ArrayList<String> types,
		ArrayList<TextField> costTextFields, ArrayList<TextField> priceTextFields) {

		
		ArrayList<Double> costValues = new ArrayList<Double>();
		ArrayList<Double> priceValues = new ArrayList<Double>();
		boolean validEntry = true;
		for (TextField costTextField : costTextFields) {
			Value costAmount = new Value(0.0, 1, 50);
    		String errorMessage = costAmount.setValue(costTextField.getText());
    		if(!errorMessage.equals("")) {
    			validEntry = false;
    			valueErrorLabel.setText(errorMessage);

    		}
   
        		costAmount.setValue(costTextField.getText());
        		costValues.add(costAmount.getAmount());
    		
    		System.out.println("cost"+ costAmount.getAmount());
			
		}
		
		for (TextField priceTextField : priceTextFields) {
			Value priceAmount = new Value(0.0, 1, 50);
    		String errorMessage = priceAmount.setValue(priceTextField.getText());
    		if(!errorMessage.equals("")) {
    			validEntry = false;
    			valueErrorLabel.setText(errorMessage);
    		}
        		priceAmount.setValue(priceTextField.getText());
        		priceValues.add(priceAmount.getAmount());
   
			
    		System.out.println("price" + priceAmount.getAmount());
			
		}
			
		ArrayList<MenuItem> itemsMasterList = new ArrayList<>();
		int m = 0;
		while (m < items.size()) {
			String type = types.get(m);
			String name = items.get(m);
			double costDouble = costValues.get(m);
			double priceDouble = priceValues.get(m);
			
			MenuItem menuOption = new MenuItem(name,type, costDouble, priceDouble);
			itemsMasterList.add(menuOption);
			m++;
			
			System.out.println("cost" + menuOption.getCost());
			System.out.println("price" + menuOption.getPrice());

		}
		
		
		if(validEntry) {
			storeTotalCostAndProfit(itemsMasterList);
		}
		applicationStage.setScene(mainScene);

	}

	private void storeTotalCostAndProfit(ArrayList<MenuItem>itemsList ) {
				
		String type = "";
		int num = 0;
		
		//get key for day
		
		for (int i = 0; i < itemsList.size();i++) {
			if (i % 3 == 0) {
				j++;
			}
			num = i;
			
			type = itemsList.get(i).getType();
		 		
		 	if (type == "appetizer") {
		 		appHash.put(j, itemsList.get(num));
		 	}
			if (type == "main course") {
				mainHash.put(j, itemsList.get(num));
			}
			if (type == "dessert") {
				dessertHash.put(j, itemsList.get(num));
			}
		}	 	 
		 	
	
	}

	public void setApplicationStage(Stage primaryStage) {
		this.applicationStage = primaryStage;
	}
}

