package application;

import java.util.ArrayList;


/**
 * Dessert class has the list of dessert that the user can select for the menu of the event. The items
 * are all stored in an ArrayList and that ArrayList is returned. This class extends the MenuItem class.
 * @author Monmoy
 *
 */
public class Dessert extends MenuItem{
	
	private static ArrayList<String> dessertList = new ArrayList<String>();
	
	/**
	 * Constructor to all all the dessert items to the ArrayList declared above.
	 */
	
		public Dessert() {
			dessertList.add("Chocolate Brownie");
			dessertList.add("Orange Sorbet");
			dessertList.add("Ice Cream");
			dessertList.add("Baklava");
			dessertList.add("Strawberry Shortcake");
			dessertList.add("Pecan Pie");
			

	}
	
		/**
		 * Getter method to return the Desserts list.
		 * @return ArrayList of Desserts
		 */
	static ArrayList<String> getDessert(){
		return new ArrayList<String>(dessertList);
	}

}
