package application;

/**
 * Class that determines and retrieves the cost of each type of menu item. It also calculates total event cost
 * by using the costs and number of guests to estimate how many items would be sold. This class extends the 
 * ProfitLoss class.
 * @author Monmoy
 *
 */
public class Cost extends ProfitLoss{
	private double appCost;
	private double mainCost;
	private double dessertCost;
	private double guests;
	private double budget;
	
	/**
	 * Constructor for the costs of each individual item type and number of guests. Sets instance variables to the 
	 * respective parameters.
	 * 
	 * @param appetizerTotalCost = Total cost of the appetizer. Sets instance variable appCost to appetizerTotalCost
	 * @param mainCourseTotalCost = Total cost of main course. Sets instance variable appCost to mainCourseTotalCost
	 * @param dessertTotalCost = Total cost of the desert. Sets instance variable appCost to dessertTotalCost
	 * @param guests = Number of guests that are estimated to come to the event. Sets instance variable guests to guests
	 * @param budget 
	 */
	
	public Cost(double appetizerTotalCost, double mainCourseTotalCost, double dessertTotalCost, double guests, double budget) {
		this.appCost = appetizerTotalCost;
		this.mainCost = mainCourseTotalCost;
		this.dessertCost = dessertTotalCost;
		this.guests = guests;
		this.budget = budget;
	}
	
	/**
	 * Getter method to return event total cost as a double.
	 * @return total = total cost of event as a double.
	 */
	double getEventTotalCost() {
			
		double total = (this.appCost + this.mainCost + this.dessertCost)*this.guests;
		
		return total;
	}
	
	/**
	 * Getter method to return message about budget as a string.
	 * Checks if budget is greater, less than or equal to the cost.
	 * @return returns the answer
	 */
	
	String getBudgetCheck() {
		double total = (this.appCost + this.mainCost + this.dessertCost)*this.guests;;
		String message = "";
		if (total > this.budget) {
			message = "You should increase your budget!";
		}
		if (total < this.budget) {
			message = "Good job! Your the event menu is within your budget!";
		}
		if (total == this.budget) {
			message ="Wow! Your cost is the same as your budget!";
		}
		
		return message;
	}
	/**
	 * Gettter method to return appetizer cost as a double.
	 * @return this.appCost
	 */
	public double getAppCost() {
		return this.appCost;
	}
	
	/** 
	 * Gettter method to return main course cost as a double.
	 * @return this.mainCost
	 */
	public double getMainCost() {
		return this.mainCost;
	}
	
	/**
	 * Getter method to return dessert cost as a double.
	 * @return this.dessertCost
	 */
	public double getDessertCost() {
		return this.dessertCost;
	}
	
	/**
	 * Getter method to return number of guests.
	 * @return this.guests
	 */
	public double getGuests() {
		return this.guests;
	}
	
	/**
	 * Getter method to return budget.
	 * @return this.budget
	 */
	public double getBudget() {
		return this.budget;
	}
	
	/**
	 * Setter method to set appetizer cost as a double.
	 * @param app = appetizer cost
	 */
	public void setAppCost(double app) {
		this.appCost = app;
	}
	
	/**
	 * Setter method to set main course cost.
	 * @param main = main course cost.
	 */
	public void setMainCost(double main) {
		this.mainCost = main;
	}
	
	/** 
	 * Setter method to set dessert cost.
	 * @param dessert = dessert cost
	 */
	public void setDessertCost(double dessert) {
		this.dessertCost = dessert;
	}
	
	/**
	 * Setter method to set number of guests.
	 * @param guests = number of guests
	 */
	public void setGuests(double guests) {
		this.guests = guests;
	}
	/**
	 * Setter method to set total budget.
	 * @param budget = total budget
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}
}

