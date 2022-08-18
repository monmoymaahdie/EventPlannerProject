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
	
	/**
	 * Constructor for the costs of each individual item type and number of guests. Sets instance variables to the 
	 * respective parameters.
	 * 
	 * @param appetizerTotalCost = Total cost of the appetizer. Sets instance variable appCost to appetizerTotalCost
	 * @param mainCourseTotalCost = Total cost of main course. Sets instance variable appCost to mainCourseTotalCost
	 * @param dessertTotalCost = Total cost of the desert. Sets instance variable appCost to dessertTotalCost
	 * @param guests = Number of guests that are estimated to come to the event. Sets instance variable guests to guests
	 */
	
	public Cost(double appetizerTotalCost, double mainCourseTotalCost, double dessertTotalCost, double guests) {
		this.appCost = appetizerTotalCost;
		this.mainCost = mainCourseTotalCost;
		this.dessertCost = dessertTotalCost;
		this.guests = guests;
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
}

