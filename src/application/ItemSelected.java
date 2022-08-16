package application;

public class ItemSelected {
	
	private String appetizer;
	private String mainCourse;
	private String dessert;
	
	public ItemSelected(String app, String main, String dessert) {
		this.appetizer = app;
		this.mainCourse = main;
		this.dessert = dessert;
	}
	
	public ItemSelected(ItemSelected copy) {
		this.appetizer = copy.appetizer;
		this.mainCourse = copy.mainCourse;
		this.dessert = copy.dessert;
		
	}
	
	public String getAppetizer() {
		return this.appetizer;
	}
	
	public String getMainCourse() {
		return this.mainCourse;
	}
	
	public String getDessert() {
		return this.dessert;
	}
	
	public void setAppetizer(String app) {
		this.appetizer = app;
	}
	
	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

}
