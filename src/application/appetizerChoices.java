package application;

import java.util.ArrayList;

public class appetizerChoices {
	
	private static ArrayList<String> appetizerList = new ArrayList<String>();
	
	public appetizerChoices() {
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
		appetizerList.add("Placeholder 1");
	}
	
	public static ArrayList<String> getAppetizerList() {
		return new ArrayList<String>(appetizerList);
	}


}
