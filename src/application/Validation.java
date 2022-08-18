package application;

/**
 * Class for handling input validation of the cost and price menu. It consists of the cost, the price and the min
 * and max possible for each value. It allows one to set the value of the cost and price only if the cost/price 
 * is valid.
 * 
 * @author Monmoy
 *
 */
public class Validation {
	private double cost;
	private double price;
	private int min;
	private int max;
	
	/**
	 * Constructor for the validation class. Makes objects based on the basic attributes of each menu item
	 * and checks if the value is valid.
	 * @param cost = cost of item
	 * @param price = price of item
	 * @param min = minimum price of item
	 * @param max = maximum price of item
	 * @throws InvalidValueException = throws this exception if the number inputted was invalid.
	 */
	public Validation(String cost, String price, int min, int max) throws InvalidValueException {
		this.min = min;
		this.max = max;
		
		//Checks if the value is within bounds, if not then throws InvalidValueException
		// The exception handling try catch statements was done with some help from Jean-Charl Pretorius
		try {
			this.cost = Integer.parseInt(cost);
			if (this.cost < 1 || this.cost > this.max) {
				
				throw new InvalidValueException(String.format("Enter a value between 1 and %c.", this.max));
			}
			
		//checks if the price and cost textfields are empty.
		} catch (NumberFormatException nfe) {
			String errorMessage = "";
			if (cost.isEmpty()) {
				errorMessage = "Enter a price & cost values for each item.";
			} else {
				// check if the user has entered a valid digit
				for (char c : cost.toCharArray()) {
					if (!Character.isDigit(c)) {
						errorMessage = "Don't include the character: " + c + "\nCost must be a positive integer.";
					}
				}
			}
			throw new InvalidValueException(errorMessage);
		}

	}
	
	
		/**
		 * Getter method for cost.
		 * @return this.cost
		 */
		public double getCost() {
			return this.cost;
		}
		
		/**
		 * Getter method for price.
		 * @return this.price
		 */
		public double getPrice() {
			return this.price;
		}
		
		/**
		 * Getter method for max value.
		 * @return this.max
		 */
		public int getMax() {
			return this.max;
		}
		
		/**
		 * Getter method for min value.
		 * @return this.min
		 */
		public int getMin() {
			return this.min;
		}
		
		/**
		 * Setter method for setting cost of item.
		 * @param cost = cost of item
		 */
		public void setCost(double cost) {
			this.cost = cost;
		}
		
		/**
		 * Setter method for setting price of item
		 * @param price = price of item
		 */
		public void setprice(double price) {
			this.price = price;
		}
		
		/**
		 * setter method for setting max value
		 * @param max = max value
		 */
		public void setMax(int max) {
			this.max = max;
		}
		
		/**
		 * Setter method for setting min value
		 * @param min = min value
		 */
		public void setMin(int min) {
			this.min = min;
		}
		
		/**setter method to set value as string
		 * 
		 * @param string
		 * @return 
		 */
		public String setValue(String string) {
			
			return "";
		}
	
	}