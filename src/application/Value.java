package application;

public class Value {
	private double amount;
	private int min;
	private int max;
	
	public Value (double amount, int min, int max){
		this.amount = amount;
		this.min = min;
		this.max = max;
	}
	

	public String setValue(String valueAsString) {
		String errorMessage =" ";
		boolean validEntry = true;
		if (!valueAsString.isEmpty()) {
			for (char c: valueAsString.toCharArray()) {
				if (!Character.isDigit(c)) {
					if (!valueAsString.matches("\\d+\\.\\d+")) {
	    				validEntry = false;
	    				errorMessage = String.format("Do not use %c in a grade. Make sure to enter a number.", c);
	    			}
				}
			}
		}
			else {
				validEntry = false;
				errorMessage ="Make sure to enter a valid number.";
			}
		
		if(validEntry) {
			this.amount = Double.parseDouble(valueAsString);
		}
		
		if (this.amount < this.min || this.amount > this.max){
			errorMessage = String.format("Amount should be between 1 and %d", this.max);
		}
		return errorMessage;
		}
	
		public double getAmount() {
			return this.amount;
		}
		
		public int getMax() {
			return this.max;
		}
		
		public int getMin() {
			return this.min;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		public void setMax(int max) {
			this.max = max;
		}
		
		public void setMin(int min) {
			this.min = min;
		}
	
	}