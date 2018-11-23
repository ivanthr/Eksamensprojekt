
public class Movie {
	private String title;
	private int year;
	private String[] categories;
	private double rating;
	
	public Movie(String title, int year, String[] categories, double rating) {
		this.title = title;
		this.year = year;
		this.categories = categories;
		this.rating = rating;
	}
	
	public String toString() {
		String cats = "[ ";
		String sep = "";
		for(String s : categories) {
			cats += sep + s;
			sep = ", ";
		}
		cats += " ]";
		
		return "" + title + ", " + year + ", " + cats + ", " + rating;
	}
}
