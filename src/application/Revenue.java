package application;

public class Revenue extends ProfitLoss {
	private double appRev;
	private double mainRev;
	private double dessertRev;
	private double guests;

	public Revenue(double appRev, double mainRev, double dessertRev, double guests) {
		this.appRev = appRev;
		this.mainRev = mainRev;
		this.dessertRev = dessertRev;
		this.guests = guests;

	}
	
	double getEventTotalPrice() {
		
		double total = (this.appRev + this.mainRev + this.dessertRev)*this.guests;
		
		return total;
	}

	public double getAppCost() {
		return this.appRev;
	}
	
	public double getMainCost() {
		return this.mainRev;
	}
	
	public double getDessertCost() {
		return this.dessertRev;
	}
	
	public double getGuests() {
		return this.guests;
	}
	
	public void setAppCost(double app) {
		this.appRev = app;
	}

	public void setMainCost(double main) {
		this.mainRev = main;
	}
	
	public void setDessertCost(double dessert) {
		this.dessertRev = dessert;
	}
	
	public void setGuests(double guests) {
		this.guests = guests;
	}

}
