package application;

public class CostAndPrice {
	
	private String itemName;
	private String itemCost;
	private String itemPrice;
	
	public CostAndPrice(String item, String text, String text2) {
		this.itemName = item;
		if (!text.isEmpty()) {
			for (char c : text.toCharArray()) {
	    		// Check if the character is a digit
	    		if (Character.isDigit(c)) {
	    			this.itemCost = text;
	    			}
	    		}
	     	}
		
		if (!text.isEmpty()) {
			for(char c : text2.toCharArray()) {
				if (Character.isDigit(c)) {
					this.itemPrice = text2;
				}
			}
		}

	}
	
	

}
