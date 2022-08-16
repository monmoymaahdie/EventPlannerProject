package application;

import java.util.ArrayList;

public class Dessert {
	
	private static ArrayList<String> dessertList = new ArrayList<String>();
	
		public Dessert() {
			dessertList.add("wow");
			dessertList.add("wow");
			dessertList.add("wow");
			dessertList.add("wow");
			dessertList.add("wow");
			dessertList.add("wow");
			dessertList.add("wow");

	}
	
	static ArrayList<String> getDessert(){
		return new ArrayList<String>(dessertList);
	}

}
