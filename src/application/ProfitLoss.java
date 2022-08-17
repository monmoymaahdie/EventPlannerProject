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

 
    String checkProfitOrLoss() {
    	double percentage = ((this.totalPrice - this.totalCost)/this.totalPrice) * 100;
    	String message = "";
    	if (this.totalCost < this.totalPrice) {
    		message = "Congratulations! You've made a " + String.valueOf(percentage) + "profit!";
    	}
    	if (this.totalCost > this.totalPrice) {
    		message = "Oh no! You're at a " + String.valueOf(percentage) + " loss! Update Menu!";
    	}
		return message;
    	
    }
    
    String findAmount() {
    	String amountMessage = "";
    	double calculatedAmount = this.totalPrice - this.totalCost;
    	if(calculatedAmount> 0) {
    		amountMessage = "You've made a profit of " + calculatedAmount;
    	}
    	if(calculatedAmount < 0){
    		amountMessage = "You've made a loss of " + calculatedAmount;
    	}
    	if(calculatedAmount == 0) {
    		amountMessage = "Sorry! You didn't make any profit...";
    	}
    	return amountMessage;
    }
}
