package application;

/**
 * Class that determines and retrieves the price from selling each type of menu item. It also calculates 
 * total event revenue by using the price and number of guests to estimate how many items would be sold. 
 * This class extends the ProfitLoss class.
 * @author Monmoy
 *
 */
public class Revenue extends ProfitLoss {
	private double appRev;
	private double mainRev;
	private double dessertRev;
	private double guests;

	/**
	 * Constructor for the revenue, ie the price of each item and the number of guests.
	 * @param appRev = revenue from the appetizer. Sets instance variable appRev to appRev.
	 * @param mainRev = revenue from the main course meal. Sets instance variable mainRev to mainRev.
	 * @param dessertRev = revenue from the dessert. Sets instance variable dessertRev to dessertRev.
	 * @param guests = number of guests for calculating total revenue. Sets instance variable guests to guests.
	 */
	public Revenue(double appRev, double mainRev, double dessertRev, double guests) {
		this.appRev = appRev;
		this.mainRev = mainRev;
		this.dessertRev = dessertRev;
		this.guests = guests;

	}
	
	/**
	 * Calculates the total revenue (as double) of the event by adding the prices of each items and multiplying 
	 * by number of guests.
	 * @return total = total revenue
	 */
	double getEventTotalPrice() {
		
		double total = (this.appRev + this.mainRev + this.dessertRev) * this.guests;
		
		return total;
	}
	
	/**
	 * getter method for revenue of appetizer
	 * @return this.appRev
	 */
	public double getAppRev() {
		return this.appRev;
	}
	
	/**
	 * getter method for revenue of main course.
	 * @return this.mainRev
	 */
	public double getMainRev() {
		return this.mainRev;
	}
	
	/**
	 * getter method for revenue of Dessert
	 * @return this.dessertRev
	 */
	public double getDessertRev() {
		return this.dessertRev;
	}
	
	/**
	 * getter method for number of guests
	 * @return this.guests
	 */
	public double getGuests() {
		return this.guests;
	}
	
	/**
	 * Setter method for appetizer revenue,ie price
	 * @param app = appetizer revenue
	 */
	public void setAppRev(double app) {
		this.appRev = app;
	}
	
	/**
	 * Setter method for main course revenue,ie price
	 * @param main = main course revenue
	 */
	public void setMainRev(double main) {
		this.mainRev = main;
	}
	
	/**
	 * Setter method for dessert revenue,ie price
	 * @param dessert = dessert revenue
	 */
	public void setDessertRev(double dessert) {
		this.dessertRev = dessert;
	}
	
	/**
	 * Setter method for number of guests
	 * @param guests = number of guests
	 */
	public void setGuests(double guests) {
		this.guests = guests;
	}

}
