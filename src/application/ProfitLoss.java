package application;

public class ProfitLoss {
	
	private double totalCost;
	private double totalPrice;
	
	public ProfitLoss() {
		
	}

	public ProfitLoss(double eventTotalCost, double eventTotalPrice) {
		this.totalCost = eventTotalCost;
		this.totalPrice = eventTotalPrice;
	}

    int getPercentage() {
       int percentage = (int) (((this.totalPrice - this.totalCost)/this.totalPrice)*100);
       return percentage;
    }
    
    String checkProfitOrLoss() {
    	int percentage = getPercentage();
    	String message = "";
    	if (this.totalCost > this.totalPrice) {
    		message = String.format("Congratulations! You've made a %c % profit!", percentage);
    	}
    	if (this.totalCost < this.totalPrice) {
    		message = String.format("Oh no! You're at a %c % loss! Update Menu!", percentage);
    	}
		return message;
    	
    }
    
    String findAmount() {
    	String amountMessage = "";
    	double calculatedAmount = this.totalPrice - this.totalCost;
    	if(calculatedAmount> 0) {
    		amountMessage = String.format("You've made a profit of $%c!", calculatedAmount);
    	}
    	if(calculatedAmount < 0){
    		amountMessage = String.format("You've made a loss of $%c!", calculatedAmount);
    	}
    	if(calculatedAmount == 0) {
    		amountMessage = "Sorry! You didn't make any profit...";
    	}
    	return amountMessage;
    }
}
