package application;

public class Cost extends ProfitLoss{
	private double appCost;
	private double mainCost;
	private double dessertCost;
	private int guests;
	
	public Cost(double appetizerTotalCost, double mainCourseTotalCost, double dessertTotalCost, int guests) {
		this.appCost = appetizerTotalCost;
		this.mainCost = mainCourseTotalCost;
		this.dessertCost = dessertTotalCost;
		this.guests = guests;
	}
	
	double getEventTotalCost() {
		
		double total = (this.appCost + this.mainCost + this.dessertCost)*this.guests;
		
		return total;
	}

	public double getAppCost() {
		return this.appCost;
	}
	
	public double getMainCost() {
		return this.mainCost;
	}
	
	public double getDessertCost() {
		return this.dessertCost;
	}
	
	public int getGuests() {
		return this.guests;
	}
	
	public void setAppCost(double app) {
		this.appCost = app;
	}

	public void setMainCost(double main) {
		this.mainCost = main;
	}
	
	public void setDessertCost(double dessert) {
		this.dessertCost = dessert;
	}
	
	public void setGuests(int guests) {
		this.guests = guests;
	}
}

