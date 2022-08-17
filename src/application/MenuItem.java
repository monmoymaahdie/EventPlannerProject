package application;

public class MenuItem {
	private String name;
	private String type;
	private double cost;
	private double price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name, String type, double cost, double price) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.price = price;
		
		
	}
	
		public String getName() {
			return this.name;
		}
		
		public String getType() {
			return this.type;
		}
		
		public double getCost() {
			return this.cost;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public void setCost(double cost) {
			this.cost = cost;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
	
		

}
