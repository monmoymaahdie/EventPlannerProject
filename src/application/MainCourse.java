package application;

import java.util.ArrayList;

public class MainCourse {
	
	private static ArrayList<String> mainCourseList = new ArrayList<String>();
	
	public MainCourse() {
		mainCourseList.add("Pulled Chicken Sandwich");
		mainCourseList.add("BBQ Beef Sandwich");
		mainCourseList.add("Burrito");
		mainCourseList.add("Meatballs and Spaghetti");
		mainCourseList.add("Chicken Fried Rice");
		mainCourseList.add("Steak");

}

static ArrayList<String> getMainCourse(){
	return new ArrayList<String>(mainCourseList);
}

}
