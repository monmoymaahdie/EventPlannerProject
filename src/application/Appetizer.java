package application;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.ObservableArray;


/**
 * Appetizer class has the list of appetizers that the user can select for the menu of the event. The items
 * are all stored in an ArrayList and that ArrayList is returned. This class extends the MenuItem class.
 * 
 * @author Monmoy
 *
 */
public class Appetizer extends MenuItem{
	
	private static ArrayList<String> appetizerList = new ArrayList<String>();
	
	/**
	 * Constructor to all all the appetizer items to the ArrayList declared above
	 */
	
	public Appetizer() {
		
		appetizerList.add("Perogies");
		appetizerList.add("Coleslaw ");
		appetizerList.add("Spicy Garlic Mushroom");
		appetizerList.add("Mozzarella Sticks ");
		appetizerList.add("Nachos");
		appetizerList.add("Chicken Taquitos");
	

	}
	
	/**
	 * Getter method to return the appetizer list.
	 * @return ArrayList of Appetizers
	 */
	
	static ArrayList<String> getAppetizer(){
		return new ArrayList<String>(appetizerList);
	}

}
