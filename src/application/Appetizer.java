package application;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.ObservableArray;

public class Appetizer {
	
	private static ArrayList<String> appetizerList = new ArrayList<String>();
	
	public Appetizer() {
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");
		appetizerList.add("Placeholder");

	}
	
	static ArrayList<String> getAppetizer(){
		return new ArrayList<String>(appetizerList);
	}

}