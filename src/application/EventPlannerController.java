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

/**
 * Controller class that manages all javafx functionality, handles GUI elements and scenes, and uses methods to 
 * ensure the data that is calcualted is displayed in the scenes as intended. It handles most of the basic functions
 * of the event planner application.
 * @author Monmoy
 *
 */
public class EventPlannerController{
	
	private Stage applicationStage;
	private Appetizer appChoices = new Appetizer();
	private MainCourse mainChoices = new MainCourse();
	private Dessert dessertChoices = new Dessert();

	
	private int j = 0;
	

	 // HashMap -> Global hashmaps for each type of menu items so we can store the values and use them whenever needed 
	 private HashMap<Integer, MenuItem> appHash= new HashMap<Integer, MenuItem>();
	 private HashMap<Integer, MenuItem> mainHash= new HashMap<Integer, MenuItem>();
	 private HashMap<Integer, MenuItem> dessertHash= new HashMap<Integer, MenuItem>();
	

    @FXML
    private ChoiceBox<Integer> eventDurationChoicebox;
    
    @FXML
    private TextField guestsTextField;
    
    @FXML
    private TextField budgetTextField;
    
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
    	
    	//Creates container for the menu selection scene
    	HBox menuRow = new HBox();
    	Label eventDay = new Label("");
    	
    	//Sets labels in the menu selection scene
    	
    	Label appetizerSelect = new Label("Select Appetizer");
    	Label mainCourseSelect = new Label("Select Main Course");
    	Label dessertSelect = new Label("Select Dessert");
    	
    	menuRow.getChildren().addAll(eventDay,appetizerSelect, mainCourseSelect, dessertSelect);
    	
    	menuSelect.getChildren().addAll(menuSelectTitle, menuRow);
    	
    	//Set Font
    	//https://coderslegacy.com/java/javafx-font/
    	menuSelectTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
    	
    	// Set Padding
    	menuSelectTitle.setPadding(new Insets(0,0,20,150));
    	appetizerSelect.setPadding(new Insets(10,20,10,80));
    	mainCourseSelect.setPadding(new Insets(10,30,10,50));
    	dessertSelect.setPadding(new Insets(10,40,10,50));
    	
    	//Error Label
    	Label errorMessage = new Label ("");
    	
    	//Select Menu Items 
    	menuSelection(menuSelect);

    	//set the new scene to menu selection scene
    	Scene menuSelectionScene = new Scene(menuSelect);
    	applicationStage.setScene(menuSelectionScene);

 
    }
    
    /**
     * Method to dynamically create choiceboxes for menu items based on number of days. 
     * Eg: If number of days = 4, it creates 4 rows and 3 columns (for appetizer, main and dessert)
     * @param menuSelect = menu selection scene container (VBox)
     */
    private void menuSelection(VBox menuSelect) {
    	
    	//while loop to create labels, ChoiceBoxes, and button
    	int numberOfDays = eventDurationChoicebox.getValue();
    	int rowCount = 1;
    	Label menuErrorLabel = new Label();
    	while (rowCount - 1 < numberOfDays) {
    		HBox menuItemRow = new HBox();
    		
    		//Create labels for each day
    		Label dayLabel = new Label("Day " + rowCount + "");
    		
    		//Create ChoiceBoxes for appetizer, main course, desserts
    		ChoiceBox<String> appetizerOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Appetizer.getAppetizer()));    		
    		ChoiceBox<String> mainCourseOptions = new ChoiceBox<String>(FXCollections.observableArrayList(MainCourse.getMainCourse()));
    		ChoiceBox<String> dessertOptions = new ChoiceBox<String>(FXCollections.observableArrayList(Dessert.getDessert()));
    	
    		
    		//Button press to change to scene where user can enter price of items
    		Label menuSelectionErrorLabel = new Label();
    		Button addCost = new Button("Enter Cost");
 
    		//Action event for button which takes the user to the scene where they can enter cost and price values
    		addCost.setOnAction(addCostEvent ->{
    			try {
            		ItemSelected menuItemChosen = new ItemSelected(appetizerOptions.getValue(), mainCourseOptions.getValue(),dessertOptions.getValue());
					getCostAndPrice(applicationStage.getScene(), menuItemChosen);
					menuSelectionErrorLabel.setText("");
				} catch (NullPointerException e) {
					menuSelectionErrorLabel.setText(e.getMessage());				}

    		});
    		
    		//populating HBox
    		menuItemRow.getChildren().addAll(dayLabel, appetizerOptions, mainCourseOptions, dessertOptions, addCost);
    		menuSelect.getChildren().addAll(menuItemRow, menuSelectionErrorLabel);
    		rowCount++;
    		
    		//Setting padding
    		HBox.setMargin(dayLabel, new Insets(0,5,10,5)); 
    		HBox.setMargin(appetizerOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(mainCourseOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(dessertOptions, new Insets(0,5,10,5)); 
    		HBox.setMargin(addCost, new Insets(0,5,10,5));
    	}
    	
    	//Creating container for calculation and summary buttons at the menu selection scene
    	HBox buttons = new HBox();
    	Button endButton = new Button("Event Summary");
    	Button calculateTotalButton = new Button("Calculate Total");
    	calculateTotalButton.setOnAction(calculateEvent -> calculateTotal(menuSelect, endButton, menuErrorLabel));

    	buttons.getChildren().addAll(calculateTotalButton,endButton);
    	
    	menuSelect.getChildren().addAll(buttons);
    }

    /**
     * Method for calculating total 
     * Here we validate the input from the initial scene and invoke Cost, Profit, and Revenue classes
     * @param mainScene = scene where its happening
     * @param * @param button = action is set for the button label
     * @param menuErrorLabel = error message is set by using try/exception
     */
   
    private void calculateTotal(VBox mainScene, Button button, Label menuErrorLabel) {
		
    	//initializing guests and budget variable 
		int guests = 0;
		double budget = 0;
		
		/**
		 * validating guest input by invoking Validation class with name guestInput
		 * value for price arguement in Validation in class is set to 1, because this is not need.
		 * We only want to validate one value
		 * We're invoking validation twice because minimum and maximum values for guests and budget are different
		 */
		
		try {
			Validation guestInput = new Validation(guestsTextField.getText(), "1", 1 , 500);
			guests = (int) guestInput.getCost();
			Validation  budgetInput = new Validation(budgetTextField.getText(),"1", 1, 100000);
			budget = guestInput.getCost();
			menuErrorLabel.setText("");
		} catch (InvalidValueException ive) {
			menuErrorLabel.setText(ive.getMessage());
		}
		
		//initializing total cost and total revenue variables for three types of menu items
		double appetizerTotalCost = 0.0;
		double mainCourseTotalCost = 0.0;
		double dessertTotalCost = 0.0;
		
		double appetizerTotalRevenue = 0.0;
		double mainCourseTotalRevenue = 0.0;
		double dessertTotalRevenue = 0.0;
		
		//for loop to keep adding cost and revenue amount by retrieving it from the hashmaps for the items
		for(int i = 1; i < appHash.size()+1; i++) {
			appetizerTotalCost += appHash.get(i).getCost();
			mainCourseTotalCost += mainHash.get(i).getCost();
			dessertTotalCost += dessertHash.get(i).getCost();
			
			appetizerTotalRevenue += appHash.get(i).getPrice();
			mainCourseTotalRevenue += mainHash.get(i).getPrice();
			dessertTotalRevenue += dessertHash.get(i).getPrice();		
			
		}
		
		//invoking cost,revenue and profitloss class and passing total cost and revenue variables, guests, and budget variables as arguements
		Cost costBreakdown = new Cost(appetizerTotalCost, mainCourseTotalCost, dessertTotalCost, guests, budget);
		Revenue priceBreakdown = new Revenue(appetizerTotalRevenue, mainCourseTotalRevenue, dessertTotalRevenue, guests);		
		ProfitLoss result = new ProfitLoss(costBreakdown.getEventTotalCost(),priceBreakdown.getEventTotalPrice());
		
		//setting the action event of the summaryPage button
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
		Label budgetDisplay = new Label(costBreakdown.getBudgetCheck());
		
		//padding
		VBox.setMargin(summaryTitle, new Insets(10,30,10,30)); 
		VBox.setMargin(eventTotalCost, new Insets(5,30,10,30)); 
		VBox.setMargin(eventTotalRevenue, new Insets(5,30,10,30)); 
		VBox.setMargin(profitOrLoss, new Insets(5,30,10,30)); 
		VBox.setMargin(resultAmount, new Insets(5,30,30,30));
		VBox.setMargin(budgetDisplay, new Insets(5,30,30,30));
		
		//font
		summaryTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30)); 
		eventTotalCost.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		eventTotalRevenue.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		profitOrLoss.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		resultAmount.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20)); 
		
		//eventSummaryContent(appHash, mainHash, dessertHash);
		
		//populating the VBox with contents
		textBox.getChildren().addAll(eventTotalCost, eventTotalRevenue, profitOrLoss, resultAmount, budgetDisplay);
		mainBox.getChildren().addAll(summaryTitle, textBox);
		
		//setting the new event summary scene
		Scene summaryScene = new Scene(mainBox);
		applicationStage.setScene(summaryScene);
		
	}
	
	

	private void getCostAndPrice(Scene scene, ItemSelected menuItems){
    	Scene mainScene = applicationStage.getScene();
 
		VBox costItems = new VBox();
		
		Label costAndPriceLabel = new Label("Enter cost and price of each item!");
			
		Label errorLabel = new Label("");
	
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
			costTextField.setPromptText("Enter Cost");
			costTextFields.add(costTextField);
			Label priceLabel = new Label("Price: $");
			TextField priceTextField = new TextField();
			priceTextField.setPromptText("Enter Price");
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
					
		Button doneButton = new Button ("Return to Menu Selection");
		doneButton.setOnAction(doneEvent ->setCostandPrice(mainScene, errorLabel,items, types, costTextFields, priceTextFields)); 
		
		costItems.getChildren().addAll(costAndPriceLabel,doneButton, errorLabel);
		
		//change scene
		Scene costScene = new Scene(costItems);
		applicationStage.setScene(costScene);
	
	
	}
	
	private void setCostandPrice(Scene mainScene, Label valueErrorLabel, ArrayList<String> items, ArrayList<String> types,
		ArrayList<TextField> costTextFields, ArrayList<TextField> priceTextFields) {

		
		ArrayList<MenuItem> itemsMasterList = new ArrayList<>();

		boolean validEntry = true;
		for (int i = 0; i < items.size(); i++) {
			String nameOfItem = items.get(i);
			String typeOfItem = types.get(i);
			String cost = costTextFields.get(i).getText();
			String price = priceTextFields.get(i).getText();
			//
			try {
				Validation valuesEntered = new Validation(cost, price, 1,30);
				MenuItem menuOptions = new MenuItem(nameOfItem, typeOfItem, valuesEntered.getCost(), valuesEntered.getPrice());
				itemsMasterList.add(menuOptions);
			} catch(InvalidValueException ive) {
				valueErrorLabel.setText(ive.getMessage());
				validEntry = false;
			}
			
		}
		
		if(validEntry) {
			storeTotalCostAndProfit(itemsMasterList);
			applicationStage.setScene(mainScene);
		}

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

