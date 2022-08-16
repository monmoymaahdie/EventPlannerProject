package application;

import java.util.ArrayList;

public class MainCourse {
	
	private static ArrayList<String> mainCourseList = new ArrayList<String>();
	
	public MainCourse() {
		mainCourseList.add("wow");
		mainCourseList.add("wow");
		mainCourseList.add("wow");
		mainCourseList.add("wow");
		mainCourseList.add("wow");
		mainCourseList.add("wow");
		mainCourseList.add("wow");

}

static ArrayList<String> getMainCourse(){
	return new ArrayList<String>(mainCourseList);
}

}
