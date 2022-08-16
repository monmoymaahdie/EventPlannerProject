package application;

public class MenuItem {
	private String name;
	private String type;
	private int cost;
	private int price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name, String type, String cost, String price) throws InvalidValueException {
		this.name = name;
		this.type = type;
		
		//for cost 
		try {
			this.cost = Integer.parseInt(cost);
		} catch(NumberFormatException nfe) {
			String errorMessage = "";
			
			if (cost.isEmpty()) {
				errorMessage = "Enter cost for each item.";
			}
			else {
				for (char c : cost.toCharArray()) {
					if(!Character.isDigit(c)) {
						errorMessage = "Enter a valid number.";
					}
				}
				throw new InvalidValueException(errorMessage);
			}
		}
		
		//for price
		try {
			this.price = Integer.parseInt(price);
		} catch(NumberFormatException nfe) {
			String errorMessage = "";
			
			if (price.isEmpty()) {
				errorMessage = "Enter cost for each item.";
			}
			else {
				for (char c : price.toCharArray()) {
					if(!Character.isDigit(c)) {
						errorMessage = "Enter a valid number.";
					}
				}
				throw new InvalidValueException(errorMessage);
			}
		}
	}
	
		public String getName() {
			return this.name;
		}
		
		public String getType() {
			return this.type;
		}
		
		public int cost() {
			return this.cost;
		}
		
		public int price() {
			return this.price;
		}
	
		
}