package application;

/**
 * Class for setting and getting the basic information about the food items, such as the name, type, cost and price.
 * Appetizer, MainCourse and Desserts all extend this class.
 * @author Monmoy
 *
 */

public class MenuItem {
	private String name;
	private String type;
	private double cost;
	private double price;
	
	/**
	 * Empty constructor for MenuItem
	 */
			
	public MenuItem() {
		
	}
	
	/** Constructor for basic information about food items in the menu.
	 * 
	 * @param name = Sets instance variable name to name
	 * @param type = Sets instance variable type to type
	 * @param cost = Sets instance variable cost to cost
	 * @param price = Sets instance variable price to price
	 */
	
	public MenuItem(String name, String type, double cost, double price) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.price = price;
		
		
	}
	
		/** 
		 * Getter method for returning name
		 * @return String for this.name 
		 */
	
		public String getName() {
			return this.name;
		}
		
		/**
		 * * Getter method for returning type
		 * @return String for this.type
		 */
		
		public String getType() {
			return this.type;
		}
		
		/** 
		 * Getter method for returning cost
		 * @return double for this.cost
		 */
		
		public double getCost() {
			return this.cost;
		}
		
		/**
		 * * Getter method for returning price
		 * @return double for this.price
		 */
		
		public double getPrice() {
			return this.price;
		}
		
		/**
		 * Setter method for setting the name
		 * @param name = name of food item
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 *  Setter method for setting the type
		 * @param type = type of item
		 */
		public void setType(String type) {
			this.type = type;
		}
		
		/**
		 *  Setter method for setting the cost
		 * @param cost = cost of item
		 */
		public void setCost(double cost) {
			this.cost = cost;
		}
		
		/**
		 *  Setter method for setting the price
		 * @param price = price of the item
		 */
		public void setPrice(double price) {
			this.price = price;
		}
	
		

}
