package application;

/**
 * Class for returning the String value of the item selected from the choicebox in the menu selection screen
 * with getters and setter methods.
 * 
 * @author Monmoy
 *
 */

public class ItemSelected {
	
	private String appetizer;
	private String mainCourse;
	private String dessert;
	
	/**
	 * Constructor for string value of the items selected
	 * @param appetizer = string value of appetizer, sets instance variable appetizer to appetizer
	 * @param mainCourse = string value of mainCourse, sets instance variable mainCourse to mainCourse
	 * @param dessert = string value of dessert, sets instance variable dessert to dessert
	 */
	
	public ItemSelected(String appetizer, String mainCourse, String dessert) {
		this.appetizer = appetizer;
		this.mainCourse = mainCourse;
		this.dessert = dessert;
	}
	
	/**
	 * Copy constructor to create a copy of the above items.
	 * @param copy
	 */
	public ItemSelected(ItemSelected copy) {
		this.appetizer = copy.appetizer;
		this.mainCourse = copy.mainCourse;
		this.dessert = copy.dessert;
		
	}
	
	/** 
	 * Getter method for returning string value of appetizer
	 * @return this.appetizer 
	 */
	public String getAppetizer() {
		return this.appetizer;
	}
	
	/**
	 * Getter method for returning string value of main course.
	 * @return this.mainCourse
	 */
	public String getMainCourse() {
		return this.mainCourse;
	}
	
	/**
	 * Getter method for returning string value of dessert.
	 * @return this.dessert
	 */
	public String getDessert() {
		return this.dessert;
	}
	
	public void setAppetizer(String appetizer) {
		this.appetizer = appetizer;
	}
	
	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

}
