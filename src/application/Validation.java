package application;

public class Validation {
	private double cost;
	private double price;
	private int min;
	private int max;
	
	
	public Validation(String cost, String price, int min, int max) throws InvalidValueException {
		this.min = min;
		this.max = max;
		
		try {
			this.cost = Integer.parseInt(cost);
			if (this.cost < 1 || this.cost > this.max) {
				throw new InvalidValueException(String.format("Enter a value between 1 and %c.", this.max));
			}
			
		} catch (NumberFormatException nfe) {
			String errorMessage = "";
			if (cost.isEmpty()) {
				errorMessage = "Enter a price & cost values for each item.";
			} else {
				// check if the user has entered an invalid numerical input of the number of reps
				for (char c : cost.toCharArray()) {
					if (!Character.isDigit(c)) {
						errorMessage = "Don't include the character: " + c + "\nReps must be a positive integer.";
					}
				}
			}
			throw new InvalidValueException(errorMessage);
		}
		
		try {
			this.price = Integer.parseInt(cost);
			if (this.price < 1 || this.price > this.max) {
				throw new InvalidValueException(String.format("Enter a value between 1 and %c.", this.max));
			}
			
		} catch (NumberFormatException nfe) {
			String errorMessage = "";
			if (cost.isEmpty()) {
				errorMessage = "Enter a price & cost values for each item.";
			} else {
				// check if the user has entered an invalid numerical input of the number of reps
				for (char c : cost.toCharArray()) {
					if (!Character.isDigit(c)) {
						errorMessage = "Don't include the character: " + c + "\nReps must be a positive integer.";
					}
				}
			}
			throw new InvalidValueException(errorMessage);
		}
	}
	
	
	
		public double getCost() {
			return this.cost;
		}
		
		public double getPrice() {
			return this.price;
		}
		public int getMax() {
			return this.max;
		}
		
		public int getMin() {
			return this.min;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}
		
		public void setprice(double price) {
			this.price = price;
		}
		
		public void setMax(int max) {
			this.max = max;
		}
		
		public void setMin(int min) {
			this.min = min;
		}

		public String setValue(String string) {
			
			return "";
		}
	
	}