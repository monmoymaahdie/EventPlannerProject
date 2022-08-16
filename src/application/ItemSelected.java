package application;

public class ItemSelected {
	
	private String appetizer;
	private String mainCourse;
	private String dessert;
	
	public ItemSelected(String appetizer, String mainCourse, String dessert) {
		this.appetizer = appetizer;
		this.mainCourse = mainCourse;
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
	
	public void setAppetizer(String appetizer) {
		this.appetizer = appetizer;
	}
	
	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

}
