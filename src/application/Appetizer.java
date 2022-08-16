package application;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.ObservableArray;

public class Appetizer {
	
	private static ArrayList<String> appetizerList = new ArrayList<String>();
	
	public Appetizer() {
		
		appetizerList.add("Perogies");
		appetizerList.add("Coleslaw ");
		appetizerList.add("Spicy Garlic Mushroom");
		appetizerList.add("Mozzarella Sticks ");
		appetizerList.add("Nachos");
		appetizerList.add("Chicken Taquitos");
	

	}
	
	static ArrayList<String> getAppetizer(){
		return new ArrayList<String>(appetizerList);
	}

}
