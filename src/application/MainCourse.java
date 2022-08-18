package application;

import java.util.ArrayList;


/**
 * MainCourse class has the list of main course meals that the user can select for the menu of the event. The items
 * are all stored in an ArrayList and that ArrayList is returned. This class extends the MenuItem class.
 * @author Monmoy
 *
 */
public class MainCourse extends MenuItem {
	
	private static ArrayList<String> mainCourseList = new ArrayList<String>();
	
	/**
	 * Constructor to all all the dessert items to the ArrayList declared above.
	 */
	public MainCourse() {
		mainCourseList.add("Pulled Chicken Sandwich");
		mainCourseList.add("BBQ Beef Sandwich");
		mainCourseList.add("Burrito");
		mainCourseList.add("Meatballs and Spaghetti");
		mainCourseList.add("Chicken Fried Rice");
		mainCourseList.add("Steak");

}

	/**
	 * Getter method to return the MainCourse list.
	 * @return ArrayList of MainCourse
	 */
static ArrayList<String> getMainCourse(){
	return new ArrayList<String>(mainCourseList);
}

}
