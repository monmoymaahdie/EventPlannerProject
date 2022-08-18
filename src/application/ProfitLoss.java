package application;

/**
 * Class for calculating profit, loss and also the percentage of the revenue that is the profit/loss for the user.
 * This is done using cost, price of items and number of guests.
 * @author Monmoy
 *
 */
public class ProfitLoss {
	
	private double totalCost;
	private double totalPrice;
	
	public ProfitLoss() {
		
	}

	public ProfitLoss(double eventTotalCost, double eventTotalPrice) {
		this.totalCost = eventTotalCost;
		this.totalPrice = eventTotalPrice;
	}

	/**
	 * Calculates the percentage of revenue that is the profit/loss and returns a string that shows this in the
	 * event summary page.
	 * @return message = message that shows the percentage of revenue that is profit/loss.
	 */
    String checkProfitOrLoss() {
    	double percentage = ((this.totalPrice - this.totalCost)/this.totalPrice) * 100;
    	String message = "";
    	if (percentage > 0) {
    		message = "Congratulations! You've made a " + String.valueOf(percentage) + "% profit!";
    	}
    	if (percentage < 0) {
    		message = "Oh no! You're at a " + String.valueOf(percentage) + "% loss!";
    	}
    	if (percentage == 0) {
    		message ="Sorry! You didn't make any profit...";
    	}
    	return message;
    	
    }
    
    /**
     * Calculates the actual monetary value of the profit/loss.
     * @return amountMessage = a message displaying a string that shows the actual monetary value of profit/loss.
     */
    String findAmount() {
    	String amountMessage = "";
    	double calculatedAmount = this.totalPrice - this.totalCost;
    	if(calculatedAmount> 0) {
    		amountMessage = "You've made a profit of $" + calculatedAmount;
    	}
    	if(calculatedAmount < 0){
    		amountMessage = "You've made a loss of $" + calculatedAmount;
    	}
    	if(calculatedAmount == 0) {
    		amountMessage = "Sorry! You didn't make any profit...";
    	}
    	return amountMessage;
    }
    	
    	/**
    	 * Getter method for total cost of event.
    	 * @return this.totalCost
    	 */
    	public double getTotalCost() {
    		return this.totalCost;
    	}
    	
    	/**
    	 * Getter method for Total price is the revenue
    	 * @return this.totalPrice
    	 */
    	public double getTotalRev(){
    		return this.totalPrice;
    	}
    	
    	/**
    	 * Setter method to set the total cost.
    	 * @param cost = total cost
    	 */
    	public void setTotalCost(double cost) {
    		this.totalCost = cost;
    	}
    	
    	/**
    	 * Setter method for total price, ie revenue.
    	 * @param price = total price
    	 */
    	public void setTotalRev(double price){
    		this.totalPrice = price;
    	}
}
