package application;

import java.util.ArrayList;

public class Dessert extends MenuItem{
	
	private static ArrayList<String> dessertList = new ArrayList<String>();
	
		public Dessert() {
			dessertList.add("Chocolate Brownie");
			dessertList.add("Orange Sorbet");
			dessertList.add("Ice Cream");
			dessertList.add("Baklava");
			dessertList.add("Strawberry Shortcake");
			dessertList.add("Pecan Pie");
			

	}
	
	static ArrayList<String> getDessert(){
		return new ArrayList<String>(dessertList);
	}

}
